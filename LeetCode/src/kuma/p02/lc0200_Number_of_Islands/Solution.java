package kuma.p02.lc0200_Number_of_Islands;

class Solution {
    int m, n;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        m = grid.length;
        n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == '1') {
                    res++;
                    helper(grid, i, j);
                }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == '*')
                    grid[i][j] = '1';

        return res;
    }

    private void helper(char[][] grid, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != '1')
            return;
        grid[x][y] = '*';
        helper(grid, x, y + 1);
        helper(grid, x, y - 1);
        helper(grid, x + 1, y);
        helper(grid, x - 1, y);
    }
}