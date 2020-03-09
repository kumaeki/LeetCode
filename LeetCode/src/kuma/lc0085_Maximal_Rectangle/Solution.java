package kuma.lc0085_Maximal_Rectangle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int m = matrix.length, n = matrix[0].length;
        int[] heights = new int[n];

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == '0')
                    heights[j] = 0;
                else
                    heights[j]++;

            res = Math.max(res, helper(heights));
        }
        return res;
    }

    private int helper(int[] heights) {
        int len = heights.length;
        int[] left = new int[len];
        left[0] = -1;
        for (int i = 1; i < len; i++) {
            int l = i - 1;
            while (l >= 0 && heights[i] <= heights[l])
                l = left[l];
            left[i] = l;
        }

        int[] right = new int[len];
        right[len - 1] = len;
        for (int i = len - 2; i >= 0; i--) {
            int r = i + 1;
            while (r < len && heights[i] <= heights[r])
                r = right[r];
            right[i] = r;
        }

        int res = 0;
        for (int i = 0; i < len; i++)
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);

        return res;
    }

    @Test
    public void simple1() {
        int expected = 6;
        char[][] matrix = new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } };
        int actual = new Solution().maximalRectangle(matrix);
        assertEquals(expected, actual);
    }
}
