package kuma.lc0032_Longest_Valid_Parentheses;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.Stack;

import org.junit.Test;

public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()) 
                    stack.push(i);
                else
                    res = Math.max(res, i - stack.peek());
            }
        }
        return res;
    }

    @Test
    public void testSimple1() {
        assertEquals(2, new Solution().longestValidParentheses("(()"));
    }

    @Test
    public void testSimple2() {
        assertEquals(4, new Solution().longestValidParentheses(")()())"));
    }

    @Test
    public void testSimple3() {
        assertEquals(20, new Solution().longestValidParentheses("(()()()()()()()()()()"));
    }

    @Test
    public void testSimple4() {
        assertEquals(6, new Solution().longestValidParentheses("(()())"));
    }
}
