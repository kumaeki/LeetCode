package kuma.p02.lc0282_Expression_Add_Operators;

import static org.junit.Assert.assertArrayEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

class Solution3 {
    // Runtime: 6 ms, faster than 99.87% of Java online submissions for Expression
    // Add Operators.
    // Memory Usage: 39.5 MB, less than 91.89% of Java online submissions for
    // Expression Add Operators.
    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<String>();
        if (num == null || num.isEmpty())
            return list;

        int n = num.length();
        char[] arr = num.toCharArray(), path = new char[2 * n - 1];
        long cur = 0;
        for (int i = 0; i < n; i++) {
            cur = cur * 10 + arr[i] - '0';
            path[i] = arr[i];
            helper(list, arr, target, i + 1, cur, cur, path, i + 1);
            if (cur == 0)
                break;
        }
        return list;
    }

    private void helper(List<String> list, char[] arr, int t, int index, long res, long pre, char[] path, int pos) {
        if (index == arr.length) {
            if (t == res)
                list.add(new String(path, 0, pos));
            return;
        }
        long cur = 0;
        for (int i = index, j = pos + 1, n = arr.length; i < n; i++, j++) {
            cur = cur * 10 + (arr[i] - '0');
            path[j] = arr[i];
            path[pos] = '*';
            helper(list, arr, t, i + 1, res - pre + pre * cur, pre * cur, path, j + 1);
            path[pos] = '+';
            helper(list, arr, t, i + 1, res + cur, cur, path, j + 1);
            path[pos] = '-';
            helper(list, arr, t, i + 1, res - cur, -cur, path, j + 1);
            if (arr[index] == '0')
                break;
        }
    }

    @Test
    public void simple1() {
        String[] expecteds = new String[] { "2*3+2", "2+3*2" };
        List<String> actuals = new Solution3().addOperators("232", 8);
        assertArrayEquals(expecteds, actuals.toArray(new String[2]));
    }

    @Test
    public void simple2() {
        String[] expecteds = new String[] { "1*0*0+9", "1*0+0+9", "1*0-0+9", "10*0+9" };
        List<String> actuals = new Solution3().addOperators("1009", 9);
        assertArrayEquals(expecteds, actuals.toArray(new String[4]));
    }
}
