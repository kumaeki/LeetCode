package kuma.p08.lc0832_Flipping_an_Image;

public class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Flipping an
    // Image.
    // Memory Usage: 39.6 MB, less than 50.00% of Java online submissions for
    // Flipping an Image.
    public int[][] flipAndInvertImage(int[][] A) {
        int m = A.length, n = A[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                res[i][j] = (A[i][n - j - 1] == 1) ? 0 : 1;
            }
        return res;
    }
}
