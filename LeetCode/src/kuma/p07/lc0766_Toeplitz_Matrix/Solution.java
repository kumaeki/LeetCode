package kuma.p07.lc0766_Toeplitz_Matrix;

class Solution {
    // Runtime: 1 ms, faster than 95.91% of Java online submissions for Toeplitz
    // Matrix.
    // Memory Usage: 39.7 MB, less than 100.00% of Java online submissions for
    // Toeplitz Matrix.
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int r = i, c = 0;
            int start = matrix[r][c];
            while (r < m && c < n)
                if (matrix[r++][c++] != start)
                    return false;
        }

        for (int j = 1; j < n; j++) {
            int r = 0, c = j;
            int start = matrix[r][c];
            while (r < m && c < n)
                if (matrix[r++][c++] != start)
                    return false;
        }
        return true;
    }
}