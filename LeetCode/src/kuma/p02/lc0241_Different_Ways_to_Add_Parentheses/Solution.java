package kuma.p02.lc0241_Different_Ways_to_Add_Parentheses;

import static org.junit.Assert.assertArrayEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

class Solution {
    // Runtime: 1 ms, faster than 97.65% of Java online submissions for Different
    // Ways to Add Parentheses.
    // Memory Usage: 39.2 MB, less than 79.17% of Java online submissions for
    // Different Ways to Add Parentheses.

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        if (input == null || input.isEmpty())
            return res;

        List<Integer> list = generateList(input);
        return helper(list, 0, list.size() - 1);
    }

    private List<Integer> generateList(String input) {
        List<Integer> list = new ArrayList<Integer>();
        int cur = 0, i = 0;
        while (i < input.length()) {
            char c = input.charAt(i);
            if ('0' <= c && c <= '9')
                cur = cur * 10 + c - '0';
            else {
                list.add(cur);
                list.add((int) input.charAt(i));
                cur = 0;
            }
            i++;
        }
        list.add(cur);
        return list;
    }

    private List<Integer> helper(List<Integer> list, int left, int right) {
        List<Integer> res = new ArrayList<Integer>();
        if (left == right)
            res.add(list.get(left));
        else {
            for (int i = left + 1; i <= right; i += 2) {
                List<Integer> list1 = helper(list, left, i - 1);
                List<Integer> list2 = helper(list, i + 1, right);
                int operate = list.get(i);
                for (int num1 : list1)
                    for (int num2 : list2) {
                        res.add(calculate(operate, num1, num2));
                    }
            }
        }
        return res;
    }

    private int calculate(int operate, int a, int b) {
        switch (operate) {
        case '*':
            return a * b;
        case '+':
            return a + b;
        case '-':
            return a - b;
        default:
            return 0;
        }
    }

    @Test
    public void simple1() {
        assertArrayEquals(new Integer[] { 0, 2 }, new Solution().diffWaysToCompute("2-1-1").toArray(new Integer[2]));
    }
}
