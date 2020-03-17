package kuma.lc0221_Maximal_Square;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Solution {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        
        int m = matrix.length, n = matrix[0].length;
        int res = 0, pre = 0;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1')
                    dp[j] = Math.min(Math.min(pre, dp[j]), dp[j - 1]) + 1;
                else
                    dp[j] = 0;
                pre = temp;
                res = Math.max(res, dp[j]);
            }
        }
        return res * res;
    }

    @Test
    public void simple1() {
        int expected = 4;
        char[][] matrix = new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } };
        int actual = new Solution().maximalSquare(matrix);
        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        int expected = 1;
        char[][] matrix = new char[][] { { '1' } };
        int actual = new Solution().maximalSquare(matrix);
        assertEquals(expected, actual);
    }

    @Test
    public void simple3() {
        int expected = 9;
        char[][] matrix = new char[][] { { '0', '0', '0', '1' }, { '1', '1', '0', '1' }, { '1', '1', '1', '1' },
                { '0', '1', '1', '1' }, { '0', '1', '1', '1' } };
        int actual = new Solution().maximalSquare(matrix);
        assertEquals(expected, actual);
    }

    @Test
    public void simple4() {
        int expected = 4;
        char[][] matrix = new char[][] { { '1', '0', '1', '1', '1' }, { '0', '1', '0', '1', '0' },
                { '1', '1', '0', '1', '1' }, { '1', '1', '0', '1', '1' }, { '0', '1', '1', '1', '1' } };
        int actual = new Solution().maximalSquare(matrix);
        assertEquals(expected, actual);
    }
}
