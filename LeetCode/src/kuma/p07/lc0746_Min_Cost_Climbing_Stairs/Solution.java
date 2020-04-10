package kuma.p07.lc0746_Min_Cost_Climbing_Stairs;

public class Solution {
    // Runtime: 1 ms, faster than 90.25% of Java online submissions for Min Cost
    // Climbing Stairs.
    // Memory Usage: 39.1 MB, less than 58.93% of Java online submissions for Min
    // Cost Climbing Stairs.
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];
        for (int i = 2; i <= len; i++)
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);

        return dp[len];
    }
}
