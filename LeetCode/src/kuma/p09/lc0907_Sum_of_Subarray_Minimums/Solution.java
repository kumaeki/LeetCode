package kuma.p09.lc0907_Sum_of_Subarray_Minimums;

class Solution {
    // Time Limit Exceeded
    public int sumSubarrayMins(int[] A) {
        int n = A.length, res = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = A[i];
            res += A[i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = n - i - 1; j >= 0; j--) {
                dp[j + i] = Math.min(dp[j + i - 1], A[j + i]);
                res += dp[j + i];
            }
            res %= 1_000_000_007;
        }
        return res;
    }
}
