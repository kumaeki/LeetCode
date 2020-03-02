package kuma.lc0064_Minimum_Path_Sum;

public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i = 1; i < n; i++)
            dp[i] = dp[i - 1] + grid[0][i];

        for (int i = 1; i < m; i++) {
            int[] arr = grid[i];
            dp[0] = dp[0] + arr[0];
            for (int j = 1; j < n; j++)
                dp[j] = Math.min(dp[j], dp[j - 1]) + arr[j];
        }

        return dp[n - 1];
    }
}
