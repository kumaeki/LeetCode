package kuma.p00.lc0071_Search_a_2D_Matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D
    // Matrix.
    // Memory Usage: 38.9 MB, less than 25.76% of Java online submissions for Search
    // a 2D Matrix.
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1;
        while (top <= bottom) {
            int mid = (top + bottom) / 2;
            if (matrix[mid][0] > target)
                bottom = mid - 1;
            else if (matrix[mid][0] < target)
                top = mid + 1;
            else
                return true;
        }
        if (bottom < 0)
            return false;

        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[bottom][mid] > target)
                right = mid - 1;
            else if (matrix[bottom][mid] < target)
                left = mid + 1;
            else
                return true;
        }
        return false;
    }

    @Test
    public void simple1() {
        assertEquals(true, new Solution().searchMatrix(new int[][] { { 1, 3 } }, 3));
    }

    @Test
    public void simple2() {
        assertEquals(true, new Solution().searchMatrix(new int[][] { { 1 }, { 3 } }, 3));
    }
}
