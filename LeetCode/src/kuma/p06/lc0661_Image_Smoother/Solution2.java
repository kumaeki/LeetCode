package kuma.p06.lc0661_Image_Smoother;

public class Solution2 {
    // Runtime: 4 ms, faster than 95.58% of Java online submissions for Image
    // Smoother.
    // Memory Usage: 40.5 MB, less than 87.50% of Java online submissions for Image
    // Smoother.
    public int[][] imageSmoother(int[][] M) {
        int m = M.length, n = M[0].length;
        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            int[] cur = new int[] { 0, 0 };
            helper(M, i, 0, cur, 1);
            for (int j = 0; j < n; j++) {
                if (j < n - 1)
                    helper(M, i, j + 1, cur, 1);

                arr[i][j] = cur[0] / cur[1];

                if (j > 0)
                    helper(M, i, j - 1, cur, -1);

            }
        }

        return arr;
    }

    private void helper(int[][] M, int i, int j, int[] cur, int operate) {
        cur[0] += (M[i][j] * operate);
        cur[1] += operate;
        if (i > 0) {
            cur[0] += (M[i - 1][j] * operate);
            cur[1] += operate;
        }
        if (i < M.length - 1) {
            cur[0] += (M[i + 1][j] * operate);
            cur[1] += operate;
        }
    }

    public static void main(String[] args) {
        new Solution2().imageSmoother(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } });
    }

}
