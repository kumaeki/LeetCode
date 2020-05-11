package kuma.p01.lc0123_Best_Time_to_Buy_and_Sell_Stock_III;

public class Solution2 {
    // Runtime: 1476 ms, faster than 5.03% of Java online submissions for Best Time
    // to Buy and Sell Stock III.
    // Memory Usage: 41.9 MB, less than 7.32% of Java online submissions for Best
    // Time to Buy and Sell Stock III.
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2)
            return 0;
        int[][] dp = new int[3][n];
        for (int k = 1; k < 3; k++) {
            for (int i = 0; i < n; i++) {
                int min = prices[0];
                for (int j = 1; j < i; j++)
                    min = Math.min(min, prices[j] - dp[k - 1][j - 1]);
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min);
            }
        }
        return dp[2][n - 1];
    }
}
