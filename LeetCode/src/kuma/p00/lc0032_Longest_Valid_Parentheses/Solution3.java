package kuma.p00.lc0032_Longest_Valid_Parentheses;

public class Solution3 {
    public int longestValidParentheses(String s) {
        int len = s.length(), res = 0;
        int[] dp = new int[len];

        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {
                int pre = s.charAt(i - 1);
                if (pre == '(')

                    dp[i] = (i > 1 ? dp[i - 2] : 0) + 2;
                
                else if (i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(')

                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] > 1 ? dp[i - dp[i - 1] - 2] : 0);

                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
