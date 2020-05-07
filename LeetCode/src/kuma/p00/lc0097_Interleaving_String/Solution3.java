package kuma.p00.lc0097_Interleaving_String;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Solution3 {
    // Runtime: 7 ms, faster than 24.12% of Java online submissions for Interleaving
    // String.
    // Memory Usage: 42 MB, less than 5.00% of Java online submissions for
    // Interleaving String.
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if (n1 + n2 != n3)
            return false;
        boolean[][][] dp = new boolean[n1 + 1][n2 + 1][n3 + 1];
        for (int i = 0; i <= n1; i++)
            for (int j = 0; j <= n2; j++) {
                int k = i + j;
                if (k == 0)
                    dp[i][j][k] = true;
                else
                    dp[i][j][k] = (i != 0 && (s1.charAt(i - 1) == s3.charAt(k - 1) && dp[i - 1][j][k - 1]))
                            || (j != 0 && (s2.charAt(j - 1) == s3.charAt(k - 1) && dp[i][j - 1][k - 1]));
            }
        return dp[n1][n2][n3];
    }

    @Test
    public void simple1() {
        assertEquals(true, new Solution3().isInterleave("a", "b", "ab"));
    }

    @Test
    public void simple2() {
        assertEquals(true, new Solution3().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    @Test
    public void simple3() {
        assertEquals(false, new Solution3().isInterleave("a", "", "c"));
    }

    @Test
    public void simple4() {
        assertEquals(true, new Solution3().isInterleave("a", "", "a"));
    }
}
