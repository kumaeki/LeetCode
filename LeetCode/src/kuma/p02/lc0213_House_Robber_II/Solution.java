package kuma.p02.lc0213_House_Robber_II;

public class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for House
    // Robber II.
    // Memory Usage: 37.3 MB, less than 6.67% of Java online submissions for House
    // Robber II.
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];
        int[] dp = new int[n + 1], dp2 = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i - 1]);
        }
        return Math.max(dp[n - 1], dp2[n]);
    }
}
