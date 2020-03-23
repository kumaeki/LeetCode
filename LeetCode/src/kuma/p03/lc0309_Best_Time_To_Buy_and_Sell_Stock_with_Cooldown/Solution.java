package kuma.p03.lc0309_Best_Time_To_Buy_and_Sell_Stock_with_Cooldown;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        
        // state machine-0: hold no stack, can buy or do nothing(stay at the state)
        // s0[i] = max(s0[i - 1], s2[i - 1])
        int s0 = 0;

        // state machine-1: hold a stack, can sell or do nothing(stay at the state)
        // s1[i] = max(s1[i - 1], s0[i] - prices[i])
        int s1 = -prices[0];

        // state machine-2: just sold a stack(come from s1 and can not stay at the
        // state)
        // s2[i] = s1[i - 1] + prices[i]
        int s2 = 0;

        for (int i = 1; i < prices.length; i++) {
            int pres2 = s2;
            s2 = s1 + prices[i];
            s1 = Math.max(s1, s0 - prices[i]);
            s0 = Math.max(s0, pres2);
        }
        return Math.max(s0, s2);
    }
    
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int len = prices.length;
        // state machine-0: hold no stack, can buy or do nothing(stay at the state)
        // s0[i] = max(s0[i - 1], s2[i - 1])
        int[] s0 = new int[len];
        s0[0] = 0;

        // state machine-1: hold a stack, can sell or do nothing(stay at the state)
        // s1[i] = max(s1[i - 1], s0[i] - prices[i])
        int[] s1 = new int[len];
        s1[0] = -prices[0];

        // state machine-2: just sold a stack(come from s1 and can not stay at the
        // state)
        // s2[i] = s1[i - 1] + prices[i]
        int[] s2 = new int[len];

        for (int i = 1; i < len; i++) {
            s0[i] = Math.max(s0[i - 1], s2[i - 1]);
            s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
            s2[i] = s1[i] + prices[i];
        }
        return Math.max(s0[len - 1], s2[len - 1]);
    }
}
