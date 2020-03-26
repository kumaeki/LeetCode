package kuma.p04_lc0Target_Sum;

public class Solution {
    // Runtime: 1 ms, faster than 100.00%
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum < S || ((sum + S) & 1) == 1)
            return 0;

        S = (sum + S) / 2;
        int[] dp = new int[S + 1];
        dp[0] = 1;
        for (int num : nums)
            for (int i = S; i >= num; i--)
                dp[i] += dp[i - num];

        return dp[S];

    }
}
