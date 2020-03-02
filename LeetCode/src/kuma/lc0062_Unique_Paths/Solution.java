package kuma.lc0062_Unique_Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++)
            dp[i] = 1;

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[j] = dp[j] + dp[j - 1];

        return dp[n - 1];
    }

    @Test
    public void testSimple1() {
        int expected = 28;
        int actual = new Solution().uniquePaths(7, 3);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSimple2() {
        int expected = 3;
        int actual = new Solution().uniquePaths(2, 3);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple3() {
        int expected = 2;
        int actual = new Solution().uniquePaths(2, 2);
        assertEquals(expected, actual);
    }
}
