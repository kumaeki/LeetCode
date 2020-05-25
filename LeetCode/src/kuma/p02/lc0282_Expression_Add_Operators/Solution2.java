package kuma.p02.lc0282_Expression_Add_Operators;

import static org.junit.Assert.assertArrayEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

public class Solution2 {
    // Runtime: 67 ms, faster than 71.98% of Java online submissions for Expression
    // Add Operators.
    // Memory Usage: 40.4 MB, less than 81.08% of Java online submissions for
    // Expression Add Operators.
    public List<String> addOperators(String num, int target) {
        int n = num.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = num.charAt(i) - '0';
        List<String> list = new ArrayList<String>();
        helper(list, arr, target, 0, 0, 0, "");
        return list;
    }

    private void helper(List<String> list, int[] arr, int target, int index, long res, long pre, String path) {
        if (index == arr.length) {
            if (target == res)
                list.add(path);
            return;
        }
        long cur = 0;
        for (int i = index, n = arr.length; i < n; i++) {
            cur = cur * 10 + arr[i];
            if (index == 0)
                helper(list, arr, target, i + 1, res + cur, cur, String.valueOf(cur));
            else {
                helper(list, arr, target, i + 1, res + cur, cur, path + "+" + cur);
                helper(list, arr, target, i + 1, res - cur, -cur, path + "-" + cur);
                helper(list, arr, target, i + 1, res - pre + pre * cur, pre * cur, path + "*" + cur);
            }
            if (arr[index] == 0)
                break;
        }
    }

    @Test
    public void simple1() {
        String[] expecteds = new String[] { "2*3+2", "2+3*2" };
        List<String> actuals = new Solution2().addOperators("232", 8);
        assertArrayEquals(expecteds, actuals.toArray(new String[2]));
    }

    @Test
    public void simple2() {
        String[] expecteds = new String[] { "1*0*0+9", "1*0+0+9", "1*0-0+9", "10*0+9" };
        List<String> actuals = new Solution2().addOperators("1009", 9);
        assertArrayEquals(expecteds, actuals.toArray(new String[4]));
    }
}
