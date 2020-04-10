package kuma.p07.lc0766_Toeplitz_Matrix;

class Solution2 {
    // Runtime: 1 ms, faster than 95.91% of Java online submissions for Toeplitz
    // Matrix.
    // Memory Usage: 39.4 MB, less than 100.00% of Java online submissions for
    // Toeplitz Matrix.
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (i > 0 && j > 0 && matrix[i][j] != matrix[i - 1][j - 1])
                    return false;
        return true;
    }
}