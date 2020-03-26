package kuma.p04.lc0494_lc0Target_Sum;

public class Solution4 {
    // Runtime: 9 ms, faster than 77.42%
    public int findTargetSumWays(int[] nums, int S) {
        if (S > 1000)
            return 0;
        int[][] dp = new int[nums.length][2001];
        dp[0][1000 + nums[0]]++;
        dp[0][1000 - nums[0]]++;
        for (int i = 0; i < nums.length - 1; i++)
            for (int j = 0; j < 2001; j++) {
                if (dp[i][j] > 0) {
                    dp[i + 1][j + nums[i + 1]] += dp[i][j];
                    dp[i + 1][j - nums[i + 1]] += dp[i][j];
                }
            }
        return dp[nums.length - 1][S + 1000];
    }
}
