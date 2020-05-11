package kuma.p01.lc0123_Best_Time_to_Buy_and_Sell_Stock_III;

public class Solution3 {
    // Runtime: 7 ms, faster than 21.03% of Java online submissions for Best Time to
    // Buy and Sell Stock III.
    // Memory Usage: 42.2 MB, less than 7.32% of Java online submissions for Best
    // Time to Buy and Sell Stock III.
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2)
            return 0;
        int[][] dp = new int[3][n];
        for (int k = 1; k < 3; k++) {
            int min = prices[0];
            for (int i = 0; i < n; i++) {
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min);
                min = Math.min(min, prices[i] - dp[k - 1][i - 1]);
            }
        }
        return dp[2][n - 1];
    }
}
