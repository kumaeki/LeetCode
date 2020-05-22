package kuma.p02.lc0264_Ugly_Number_II;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Solution2 {
    // Runtime: 2 ms, faster than 95.97% of Java online submissions for Ugly Number
    // II.
    // Memory Usage: 37.4 MB, less than 9.09% of Java online submissions for Ugly
    // Number II.
    public int nthUglyNumber(int n) {
        int num2 = 2, num3 = 3, num5 = 5;
        int index2 = 1, index3 = 1, index5 = 1;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int cur = Math.min(num2, Math.min(num3, num5));
            dp[i] = cur;
            if (cur == num2) {
                num2 = 2 * dp[index2++];
            }
            if (cur == num3) {
                num3 = 3 * dp[index3++];
            }
            if (cur == num5) {
                num5 = 5 * dp[index5++];
            }
        }
        return dp[n - 1];
    }

    @Test
    public void simple1() {
        assertEquals(15, new Solution2().nthUglyNumber(11));
    }
}
