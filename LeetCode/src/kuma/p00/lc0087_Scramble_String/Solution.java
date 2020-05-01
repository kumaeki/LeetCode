package kuma.p00.lc0087_Scramble_String;

import java.util.*;

public class Solution {
    // Runtime: 10 ms, faster than 24.33% of Java online submissions for Scramble
    // String.
    // Memory Usage: 39.5 MB, less than 37.50% of Java online submissions for
    // Scramble String.

    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if (s2.length() != n)
            return false;
        if (n == 0)
            return true;
        boolean[][][] dp = new boolean[n][n][n + 1];
        for (int k = 1; k <= n; k++) {
            int len = n - k;
            for (int i = 0; i <= len; i++) {
                for (int j = 0; j <= len; j++) {
                    if (k == 1)
                        dp[i][j][k] = s1.charAt(i) == s2.charAt(j);
                    else
                        for (int q = 1; q < k && !dp[i][j][k]; q++)
                            dp[i][j][k] = (dp[i][j][q] && dp[i + q][j + q][k - q])
                                    || (dp[i][j + k - q][q] && dp[i + q][j][k - q]);
                }
            }
        }

        return dp[0][0][n];
    }
}
