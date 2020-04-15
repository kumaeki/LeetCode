package kuma.p08.lc0867_Transpose_Matrix;

public class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Transpose
    // Matrix.
    // Memory Usage: 40.1 MB, less than 91.67% of Java online submissions for
    // Transpose Matrix.
    public int[][] transpose(int[][] A) {
        int m = A.length, n = A[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                res[j][i] = A[i][j];
        return res;
    }
}
