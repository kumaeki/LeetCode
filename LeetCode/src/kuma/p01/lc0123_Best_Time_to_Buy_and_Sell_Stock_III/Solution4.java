package kuma.p01.lc0123_Best_Time_to_Buy_and_Sell_Stock_III;

public class Solution4 {
    // Runtime: 5 ms, faster than 26.10% of Java online submissions for Best Time to
    // Buy and Sell Stock III.
    // Memory Usage: 41.6 MB, less than 7.32% of Java online submissions for Best
    // Time to Buy and Sell Stock III.
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2)
            return 0;
        int[] dp = new int[3], min = new int[] { prices[0], prices[0], prices[0] };
        for (int i = 1; i < n; i++) {
            for (int k = 1; k < 3; k++) {
                dp[k] = Math.max(dp[k], prices[i] - min[k]);
                min[k] = Math.min(min[k], prices[i] - dp[k - 1]);
            }
        }
        return dp[2];
    }
}
