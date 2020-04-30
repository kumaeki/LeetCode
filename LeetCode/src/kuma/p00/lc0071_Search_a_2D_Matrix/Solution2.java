package kuma.p00.lc0071_Search_a_2D_Matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Solution2 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D
    // Matrix.
    // Memory Usage: 38.9 MB, less than 25.76% of Java online submissions for Search
    // a 2D Matrix.
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x >= 0 && x < m && y >= 0 && y < n) {
            if (matrix[x][y] > target)
                y--;
            else if (matrix[x][y] < target)
                x++;
            else
                return true;
        }
        return false;
    }

    @Test
    public void simple1() {
        assertEquals(true, new Solution2().searchMatrix(new int[][] { { 1, 3 } }, 3));
    }

    @Test
    public void simple2() {
        assertEquals(true, new Solution2().searchMatrix(new int[][] { { 1 }, { 3 } }, 3));
    }
}
