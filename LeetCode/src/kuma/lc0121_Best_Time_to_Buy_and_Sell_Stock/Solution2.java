package kuma.lc0121_Best_Time_to_Buy_and_Sell_Stock;

public class Solution2 {
    public int maxProfit(int[] prices) {
        int left = 0, res = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[left];
            if (diff >= 0)
                res = Math.max(res, diff);
            else
                left = i;
        }
        return res;
    }
}
