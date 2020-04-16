package kuma.p08.lc0873_Length_of_Longest_Fibonacci_Subsequence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class Solution3 {
    // Runtime: 21 ms, faster than 98.45% of Java online submissions for Length of
    // Longest Fibonacci Subsequence.
    // Memory Usage: 48.2 MB, less than 14.29% of Java online submissions for Length
    // of Longest Fibonacci Subsequence.
    public int lenLongestFibSubseq(int[] A) {
        int n = A.length, res = 0;
        int[][] dp = new int[n][n];
        for (int k = 2; k < n; k++) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (A[i] + A[j] > A[k])
                    j--;
                else if (A[i] + A[j] < A[k])
                    i++;
                else {
                    dp[j][k] = dp[i][j] + 1;
                    res = Math.max(res, dp[j][k]);
                    i++;
                    j--;
                }
            }
        }
        return res == 0 ? 0 : res + 2;
    }

    @Test
    public void simple1() {
        assertEquals(5, new Solution3().lenLongestFibSubseq(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
    }
}
