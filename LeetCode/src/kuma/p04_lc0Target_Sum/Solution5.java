package kuma.p04_lc0Target_Sum;

public class Solution5 {
    // Runtime: 7 ms, faster than 83.03%
    public int findTargetSumWays(int[] nums, int S) {
        if (S > 1000)
            return 0;
        int[] dp = new int[2001];
        dp[1000 + nums[0]]++;
        dp[1000 - nums[0]]++;
        for (int i = 0; i < nums.length - 1; i++) {
            int[] next = new int[2001];
            for (int j = 0; j < 2001; j++) {
                if (dp[j] > 0) {
                    next[j + nums[i + 1]] += dp[j];
                    next[j - nums[i + 1]] += dp[j];
                }
            }
            dp = next;
        }
        return dp[S + 1000];
    }
}
