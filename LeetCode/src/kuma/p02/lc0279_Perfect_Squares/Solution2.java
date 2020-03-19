package kuma.p02.lc0279_Perfect_Squares;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution2 {
    public int numSquares(int n) {
        if (n < 4)
            return n;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        int sq, val;
        for (int i = 1; i < n + 1; i++) {
            dp[i] = i;
            if (n >= 4) {
                sq = (int) Math.sqrt(i);
                for (int j = sq; j > 0; j--) {
                    val = j * j;
                    if (val == i) {
                        dp[i] = 1;
                        break;
                    } else
                        dp[i] = Math.min(dp[i], dp[i - val] + dp[val]);

                }

            }
        }
        return dp[n];
    }

    @Test
    public void Simple2() {
        int expected = 3;
        int actual = new Solution2().numSquares(12);
        assertEquals(expected, actual);
    }
}
