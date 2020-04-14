package kuma.p08.lc0835_Image_Overlap;

class Solution {
    // Runtime: 5 ms, faster than 98.22% of Java online submissions for Image
    // Overlap.
    // Memory Usage: 38.6 MB, less than 100.00% of Java online submissions for Image
    // Overlap.
    public int largestOverlap(int[][] A, int[][] B) {
        int len = A.length, ml = 2 * len + 1;
        int[][] matrix = new int[ml][ml];
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++)
                if (A[i][j] == 1)
                    for (int m = 0; m < len; m++)
                        for (int n = 0; n < len; n++)
                            if (B[m][n] == 1)
                                matrix[i - m + len][j - n + len]++;

        int res = 0;
        for (int[] row : matrix)
            for (int val : row)
                res = Math.max(res, val);

        return res;
    }
}