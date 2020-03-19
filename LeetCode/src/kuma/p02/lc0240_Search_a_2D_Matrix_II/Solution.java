package kuma.p02.lc0240_Search_a_2D_Matrix_II;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1, val;
        while (x < m && n >= 0) {
            val = matrix[x][y];
            if (val > target)
                y--;
            else if (val < target)
                x++;
            else
                return true;
        }

        return false;
    }

}
