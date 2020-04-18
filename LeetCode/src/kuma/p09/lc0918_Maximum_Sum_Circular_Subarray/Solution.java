package kuma.p09.lc0918_Maximum_Sum_Circular_Subarray;

public class Solution {
    // Time Limit Exceeded
    public int maxSubarraySumCircular(int[] A) {
        int n = A.length, res = Integer.MIN_VALUE;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[0] = A[i];
            // System.out.println("dp["+i+"][0] : " + dp[i][0]);
            res = Math.max(res, A[i]);
            for (int j = 1; j < n; j++) {
                int a = A[(i + j) % n];
                dp[j] = Math.max(dp[j - 1] + a, a);
                // System.out.println("dp["+i+"]["+j+"] : " + dp[i][j]);
                res = Math.max(res, dp[j]);
            }
        }

        return res;
    }
}
