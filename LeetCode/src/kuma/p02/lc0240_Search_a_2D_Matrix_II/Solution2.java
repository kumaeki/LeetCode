package kuma.p02.lc0240_Search_a_2D_Matrix_II;

public class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        return helper(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    private boolean helper(int[][] matrix, int target, int startx, int starty, int endx, int endy) {
        if (startx > endx || starty > endy)
            return false;
        int x = (startx + endx) / 2, y = (starty + endy) / 2;
        int val = matrix[x][y];
        if (val < target) {
            return helper(matrix, target, startx, y + 1, endx, endy) || helper(matrix, target, x + 1, starty, endx, y);

        } else if (val > target) {
            return helper(matrix, target, startx, starty, x - 1, endy)
                    || helper(matrix, target, x, starty, endx, y - 1);
        } else
            return true;
    }
}
