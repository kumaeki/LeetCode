package kuma.p02.lc0224_Basic_Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

public class Solution {
    // Runtime: 8 ms, faster than 55.94% of Java online submissions for Basic
    // Calculator.
    // Memory Usage: 41.8 MB, less than 44.61% of Java online submissions for Basic
    // Calculator.
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0, operate = 1, cur = 0;
        for (char c : s.toCharArray()) {
            if ('0' <= c && c <= '9') {
                cur = cur * 10 + c - '0';
            } else if (c == '+') {
                res += cur * operate;
                cur = 0;
                operate = 1;
            } else if (c == '-') {
                res += cur * operate;
                cur = 0;
                operate = -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(operate);
                res = 0;
                operate = 1;
            } else if (c == ')') {
                res += cur * operate;
                res *= stack.pop();
                res += stack.pop();
                cur = 0;
                operate = 1;
            }
        }
        return res + cur * operate;
    }

    @Test
    public void simple1() {
        assertEquals(2, new Solution().calculate("1+1"));
    }

    @Test
    public void simple2() {
        assertEquals(2, new Solution().calculate("2-(5-6 - (7 - 8))"));
    }
}
