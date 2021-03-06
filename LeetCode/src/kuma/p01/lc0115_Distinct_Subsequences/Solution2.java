package kuma.p01.lc0115_Distinct_Subsequences;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution2 {
    // Runtime: 5 ms, faster than 90.35% of Java online submissions for Distinct Subsequences.
    // Memory Usage: 40.2 MB, less than 7.69% of Java online submissions for Distinct Subsequences.
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            dp[i][n] = 1;

        for (int i = m - 1; i >= 0; i--) {
            char c = s.charAt(i);
            for (int j = n - 1; j >= 0; j--) {
                if (c == t.charAt(j))
                    dp[i][j] = dp[i + 1][j] + dp[i + 1][j + 1];
                else
                    dp[i][j] = dp[i + 1][j];
            }
        }
        return dp[0][0];
    }

    @Test
    public void simple1() {
        assertEquals(3, new Solution2().numDistinct("rabbbit", "rabbit"));
    }

    @Test
    public void simple2() {
        assertEquals(0, new Solution2().numDistinct("", "rabbit"));
    }

    @Test
    public void simple3() {
        assertEquals(1, new Solution2().numDistinct("rabbbit", ""));
    }

    @Test
    public void simple4() {
        assertEquals(5, new Solution2().numDistinct("babgbag", "bag"));
    }
}
