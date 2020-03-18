package kuma.p02.lc0221_Maximal_Square;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Solution2 {

    int m, n;

    public int maximalSquare(char[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int res = 0;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == '1')
                    res = Math.max(res, helper(matrix, i, j, 0));

        return res * res;
    }

    private int helper(char[][] matrix, int x, int y, int w) {
        int xn = x + w, yn = y + w;
        if (xn >= m || yn >= n)
            return -1;

        for (int i = 0; i <= w; i++) {
            if (matrix[xn][y + i] != '1')
                return -1;
            if (matrix[x + i][yn] != '1')
                return -1;
        }

        return Math.max(w + 1, helper(matrix, x, y, w + 1));
    }

    @Test
    public void simple1() {
        int expected = 4;
        char[][] matrix = new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } };
        int actual = new Solution2().maximalSquare(matrix);
        assertEquals(expected, actual);
    }
}
