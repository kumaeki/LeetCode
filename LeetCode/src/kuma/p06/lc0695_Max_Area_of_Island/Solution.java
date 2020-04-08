package kuma.p06.lc0695_Max_Area_of_Island;

public class Solution {
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Max Area of
    // Island.
    // Memory Usage: 40.2 MB, less than 96.30% of Java online submissions for Max
    // Area of Island.

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1)
                    max = Math.max(max, helper(grid, m, n, i, j));

        return max;
    }

    private int helper(int[][] g, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || g[i][j] == 0)
            return 0;

        g[i][j] = 0;
        return helper(g, m, n, i - 1, j) + helper(g, m, n, i + 1, j) + helper(g, m, n, i, j - 1)
                + helper(g, m, n, i, j + 1);

    }

    public static void main(String[] args) {
        new Solution().maxAreaOfIsland(
                new int[][] { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 1 } });
    }
}
