package kuma.p03.lc0309_Best_Time_To_Buy_and_Sell_Stock_with_Cooldown;

public class Solution2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int len = prices.length, min = 0, res = 0;
        int[] dp = new int[len];
        dp[0] = 0;
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1];
            if (prices[i] <= prices[min]) {
                min = i;
                
            } else {
                for(int j = min; j <i; j++)
                    dp[i] = Math.max(dp[i], prices[i] - prices[j] + (j > 1 ? dp[j - 2] : 0));
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
