package kuma.p02.lc0282_Expression_Add_Operators;

import static org.junit.Assert.assertArrayEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

public class Solution {
    // Runtime: 97 ms, faster than 34.10% of Java online submissions for Expression
    // Add Operators.
    // Memory Usage: 40.2 MB, less than 83.78% of Java online submissions for
    // Expression Add Operators.
    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<String>();
        helper(list, num, target, 0, 0, 0, "");
        return list;
    }

    private void helper(List<String> list, String num, int target, int index, long res, long pre, String path) {
        if (index == num.length()) {
            if (target == res)
                list.add(path);
            return;
        }

        for (int i = index; i < num.length(); i++) {
            long cur = Long.valueOf(num.substring(index, i + 1));
            if (index == 0)
                helper(list, num, target, i + 1, res + cur, cur, String.valueOf(cur));
            else {
                helper(list, num, target, i + 1, res + cur, cur, path + "+" + cur);
                helper(list, num, target, i + 1, res - cur, -cur, path + "-" + cur);
                helper(list, num, target, i + 1, res - pre + pre * cur, pre * cur, path + "*" + cur);
            }
            if (num.charAt(index) == '0')
                break;
        }
    }

    @Test
    public void simple1() {
        String[] expecteds = new String[] { "2*3+2", "2+3*2" };
        List<String> actuals = new Solution().addOperators("232", 8);
        assertArrayEquals(expecteds, actuals.toArray(new String[2]));
    }
}
