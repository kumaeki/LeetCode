package kuma.p00.lc0063_Unique_Paths_II;

class Solution2 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique
    // Paths II.
    // Memory Usage: 38.4 MB, less than 96.92% of Java online submissions for Unique
    // Paths II.
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] pre = new int[n], cur = new int[n];
        pre[0] = 1 - obstacleGrid[0][0];
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1)
                break;
            pre[i] = pre[i - 1];
        }

        for (int i = 1; i < m; i++) {
            cur[0] = obstacleGrid[i][0] == 0 ? pre[0] : 0;
            for (int j = 1; j < n; j++) {
                cur[j] = obstacleGrid[i][j] == 1 ? 0 : pre[j] + cur[j - 1];
            }
            pre = cur;
        }

        return pre[n - 1];
    }
}
