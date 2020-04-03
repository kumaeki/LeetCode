package kuma.p05.lc0566_Reshape_the_Matrix;

public class Solution {
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Reshape the
    // Matrix.
    // Memory Usage: 40.6 MB, less than 55.56% of Java online submissions for
    // Reshape the Matrix.
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c || m == r)
            return nums;

        int[][] res = new int[r][c];
        int index = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                res[index / c][index % c] = nums[i][j];
                index++;
            }

        return res;
    }

    public static void main(String[] args) {
        new Solution().matrixReshape(new int[][] { { 1 }, { 2 }, { 3 }, { 4 } }, 2, 2);
    }
}
