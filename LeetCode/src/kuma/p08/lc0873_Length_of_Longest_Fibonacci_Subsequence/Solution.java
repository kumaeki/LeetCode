package kuma.p08.lc0873_Length_of_Longest_Fibonacci_Subsequence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Solution {
    // Runtime: 126 ms, faster than 10.17% of Java online submissions for Length of
    // Longest Fibonacci Subsequence.
    // Memory Usage: 48.6 MB, less than 14.29% of Java online submissions for Length
    // of Longest Fibonacci Subsequence.
    public int lenLongestFibSubseq(int[] A) {
        int n = A.length, res = 0;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n - 2; i++)
            for (int j = i + 1; j < n - 1; j++) {
                int target = A[i] + A[j];
                int index = Arrays.binarySearch(A, target);
                if (index >= 0 && index < n) {
                    dp[j][index] = dp[i][j] + 1;
                    res = Math.max(res, dp[j][index]);
                }
            }
        return res == 0 ? 0 : res + 2;
    }

    @Test
    public void simple1() {
        assertEquals(5, new Solution().lenLongestFibSubseq(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
    }
}
