package kuma.p00.lc0063_Unique_Paths_II;

class Solution {
    // Runtime: 1 ms, faster than 20.12% of Java online submissions for Unique Paths
    // II.
    // Memory Usage: 38.6 MB, less than 84.62% of Java online submissions for Unique
    // Paths II.
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1 - obstacleGrid[0][0];
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1)
                break;
            dp[i][0] = dp[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1)
                break;
            dp[0][j] = dp[0][j - 1];
        }

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];

        return dp[m - 1][n - 1];
    }
}
