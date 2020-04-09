package kuma.p07.lc0714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee;

public class Solution {
    // Runtime: 3 ms, faster than 93.08% of Java online submissions for Best Time to
    // Buy and Sell Stock with Transaction Fee.
    // Memory Usage: 48.4 MB, less than 100.00% of Java online submissions for Best
    // Time to Buy and Sell Stock with Transaction Fee.
    public int maxProfit(int[] prices, int fee) {
        // max profit , hold stock, be able to sell
        int cash = 0;
        // max profit , hold no stock, be able to buy
        int hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int pre_cash = cash;
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, pre_cash - prices[i]);
        }
        return cash;
    }
}
