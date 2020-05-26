package kuma.p03.lc0304_Range_Sum_Query_2D_Immutable;

class NumMatrix {
    // Runtime: 11 ms, faster than 80.50% of Java online submissions for Range Sum
    // Query 2D - Immutable.
    // Memory Usage: 45.2 MB, less than 33.33% of Java online submissions for Range
    // Sum Query 2D - Immutable.
    int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        int m = matrix.length, n = matrix[0].length;
        prefixSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = prefixSum[i][j - 1] + prefixSum[i - 1][j] + matrix[i - 1][j - 1];
                if (i > 1 && j > 1)
                    prefixSum[i][j] -= prefixSum[i - 1][j - 1];
            }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSum[row2 + 1][col2 + 1] - prefixSum[row1][col2 + 1] - prefixSum[row2 + 1][col1]
                + prefixSum[row1][col1];
    }
}