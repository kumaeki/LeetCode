package kuma.p00.lc0096_Unique_Binary_Search_Trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += (dp[j] * dp[i - j - 1]);
            }
        }

        return dp[n];
    }

    @Test
    public void simple1() {
        int expected = 1;
        int actual = new Solution().numTrees(1);
        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        int expected = 2;
        int actual = new Solution().numTrees(2);
        assertEquals(expected, actual);
    }

    @Test
    public void simple3() {
        int expected = 5;
        int actual = new Solution().numTrees(3);
        assertEquals(expected, actual);
    }

    @Test
    public void simple4() {
        int expected = 14;
        int actual = new Solution().numTrees(4);
        assertEquals(expected, actual);
    }

    @Test
    public void simple5() {
        int expected = 42;
        int actual = new Solution().numTrees(5);
        assertEquals(expected, actual);
    }
}