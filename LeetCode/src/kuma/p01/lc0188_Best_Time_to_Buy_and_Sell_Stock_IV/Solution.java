package kuma.p01.lc0188_Best_Time_to_Buy_and_Sell_Stock_IV;

public class Solution {
    // Runtime: 2 ms, faster than 96.39% of Java online submissions for Best Time to
    // Buy and Sell Stock IV.
    // Memory Usage: 39.5 MB, less than 25.00% of Java online submissions for Best
    // Time to Buy and Sell Stock IV.
    public int maxProfit(int k, int[] prices) {
        int n = prices.length, res = 0;
        if (n < 2)
            return res;
        if (k > n / 2) {
            for (int i = 1; i < n; i++) {
                int dif = prices[i] - prices[i - 1];
                if (dif > 0)
                    res += dif;
            }
            return res;
        }

        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int pre = -prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + pre);
                pre = Math.max(pre, dp[i - 1][j - 1] - prices[j]);

            }
        }
        return dp[k][n - 1];
    }
}
