package kuma.p01.lc0174_Dungeon_Game;

public class Solution {
    // Runtime: 3 ms, faster than 15.93% of Java online submissions for Dungeon
    // Game.
    // Memory Usage: 39.1 MB, less than 88.24% of Java online submissions for
    // Dungeon Game.

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = Integer.MAX_VALUE;

        dp[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--) {
                int h = dp[i][j] - dungeon[i][j];
                if (i > 0) {
                    dp[i - 1][j] = Math.min(dp[i - 1][j], h);
                    if (dp[i - 1][j] <= 0)
                        dp[i - 1][j] = 1;
                }
                if (j > 0) {
                    dp[i][j - 1] = Math.min(dp[i][j - 1], h);
                    if (dp[i][j - 1] <= 0)
                        dp[i][j - 1] = 1;
                }
            }
        dp[0][0] -= dungeon[0][0];
        return dp[0][0] <= 0 ? 1 : dp[0][0];
    }
}
