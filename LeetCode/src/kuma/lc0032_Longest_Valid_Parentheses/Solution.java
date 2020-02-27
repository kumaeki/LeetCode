package kuma.lc0032_Longest_Valid_Parentheses;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length(), res = 0;
        int[] dp = new int[len];

        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {
                int pre = s.charAt(i - 1);
                if (pre == '(')
                    // dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                    dp[i] = (i > 1 ? dp[i - 2] : 0) + 2;
                else if (i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(')
                    // dp[i] = dp[i - 1] + 2 + (i - 2 - dp[i - 1] >= 0 ? dp[i - 2 - dp[i - 1]] : 0);
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] > 1 ? dp[i - dp[i - 1] - 2] : 0);

                res = Math.max(res, dp[i]);
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
