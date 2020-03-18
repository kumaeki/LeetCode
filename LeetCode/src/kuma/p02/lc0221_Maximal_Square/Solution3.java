package kuma.p02.lc0221_Maximal_Square;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Solution3 {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int m = matrix.length, n = matrix[0].length;
        int res = 0;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j] - '0';
                res = Math.max(res, dp[i][j]);
            }
                

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1')
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                res = Math.max(res, dp[i][j]);
            }

        return res * res;
    }

    @Test
    public void simple1() {
        int expected = 4;
        char[][] matrix = new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } };
        int actual = new Solution3().maximalSquare(matrix);
        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        int expected = 1;
        char[][] matrix = new char[][] { { '1' } };
        int actual = new Solution3().maximalSquare(matrix);
        assertEquals(expected, actual);
    }
}
