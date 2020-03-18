package kuma.p00.lc0048_Rotate_Image;

public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;

        for (int i = 0, n = matrix.length; i <= n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int x1 = j, y1 = n - i - 1;
                int x2 = n - i - 1, y2 = n - j - 1;
                int x3 = n - j - 1, y3 = i;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[x3][y3];
                matrix[x3][y3] = matrix[x2][y2];
                matrix[x2][y2] = matrix[x1][y1];
                matrix[x1][y1] = temp;
            }
        }
    }
}
