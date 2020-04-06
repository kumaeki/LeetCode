package kuma.p06.lc0661_Image_Smoother;

public class Solution {
    // Runtime: 11 ms, faster than 13.05% of Java online submissions for Image
    // Smoother.
    // Memory Usage: 62.3 MB, less than 6.25% of Java online submissions for Image
    // Smoother.
    public int[][] imageSmoother(int[][] M) {
        int m = M.length, n = M[0].length;
        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            int sum = M[i][0], count = 1;
            if (i > 0) {
                sum += M[i - 1][0];
                count++;
            }
            if (i < m - 1) {
                sum += M[i + 1][0];
                count++;
            }
            for (int j = 0; j < n; j++) {
                if (j < n - 1) {
                    sum += M[i][j + 1];
                    count++;
                    if (i > 0) {
                        sum += M[i - 1][j + 1];
                        count++;
                    }
                    if (i < m - 1) {
                        sum += M[i + 1][j + 1];
                        count++;
                    }
                }
                arr[i][j] = sum / count;
                if (j > 0) {
                    sum -= M[i][j - 1];
                    count--;
                    if (i > 0) {
                        sum -= M[i - 1][j - 1];
                        count--;
                    }
                    if (i < m - 1) {
                        sum -= M[i + 1][j - 1];
                        count--;
                    }
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        new Solution().imageSmoother(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } });
    }

}
