package kuma.p03.lc0322_Coin_Change;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution {

    public int coinChange(int[] coins, int amount) {
        int res = helper(coins, amount, new int[amount + 1]);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int helper(int[] coins, int amount, int[] dp) {
        int min = Integer.MAX_VALUE;
        if (amount == 0)
            return 0;
        if (amount < 0)
            return min;
        if (dp[amount] > 0)
            return dp[amount];
        for (int coin : coins) {
            int res = helper(coins, amount - coin, dp);
            if (res < min - 1)
                min = res + 1;
        }
        dp[amount] = min;
        return min;
    }

    @Test
    public void simple1() {
        int expected = -1;
        int[] coins = new int[] { 3, 4, 5 };
        int amount = 2;
        int actual = new Solution().coinChange(coins, amount);
        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        int expected = 3;
        int[] coins = new int[] { 1, 2, 5 };
        int amount = 11;
        int actual = new Solution().coinChange(coins, amount);
        assertEquals(expected, actual);
    }

}
