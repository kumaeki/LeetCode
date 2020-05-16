package kuma.p01.lc0174_Dungeon_Game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

public class Solution3 {
    // Runtime: 1 ms, faster than 93.10% of Java online submissions for Dungeon
    // Game.
    // Memory Usage: 39.3 MB, less than 82.35% of Java online submissions for
    // Dungeon Game.
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int h = dp[j] - dungeon[i][j];
                if (j > 0) {
                    dp[j - 1] = Math.min(dp[j - 1], h);
                    dp[j - 1] = dp[j - 1] <= 0 ? 1 : dp[j - 1];
                }
                if (i > 0)
                    dp[j] = h <= 0 ? 1 : h;
            }
        }
        dp[0] -= dungeon[0][0];
        return dp[0] <= 0 ? 1 : dp[0];
    }

    // Runtime: 2 ms, faster than 47.53% of Java online submissions for Dungeon
    // Game.
    // Memory Usage: 39.2 MB, less than 82.35% of Java online submissions for
    // Dungeon Game.
    public int calculateMinimumHP2(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[] cur = new int[n], up;
        for (int j = 0; j < n; j++) {
            cur[j] = Integer.MAX_VALUE;
        }
        cur[n - 1] = 1;

        for (int i = m - 1; i >= 0; i--) {
            up = new int[n];
            Arrays.fill(up, Integer.MAX_VALUE);
            for (int j = n - 1; j >= 0; j--) {
                int h = cur[j] - dungeon[i][j];
                if (j > 0) {
                    cur[j - 1] = Math.min(cur[j - 1], h);
                    if (cur[j - 1] <= 0)
                        cur[j - 1] = 1;
                }
                if (i > 0) {
                    up[j] = Math.min(up[j], h);
                    if (up[j] <= 0)
                        up[j] = 1;
                }
            }
            if (i != 0)
                cur = up;
        }
        cur[0] -= dungeon[0][0];
        return cur[0] <= 0 ? 1 : cur[0];
    }

    @Test
    public void simple1() {
        assertEquals(7,
                new Solution3().calculateMinimumHP(new int[][] { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } }));
    }
}
