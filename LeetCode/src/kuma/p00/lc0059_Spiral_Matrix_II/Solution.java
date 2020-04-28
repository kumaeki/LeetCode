package kuma.p00.lc0059_Spiral_Matrix_II;

public class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral
    // Matrix II.
    // Memory Usage: 37.3 MB, less than 8.33% of Java online submissions for Spiral
    // Matrix II.
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int cur = 1;
        for (int i = 0; i <= n / 2; i++) {
            for (int j = i; j < n - i; j++)
                res[i][j] = cur++;
            for (int j = i + 1; j < n - i; j++)
                res[j][n - i - 1] = cur++;
            for (int j = n - i - 2; j >= i; j--)
                res[n - i - 1][j] = cur++;
            for (int j = n - i - 2; j > i; j--)
                res[j][i] = cur++;
        }
        return res;
    }
}
