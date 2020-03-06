package kuma.lc0084_Largest_Rectangle_in_Histogram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;

        int len = heights.length;

        int[] arrLeft = new int[len];
        arrLeft[0] = -1;
        for (int i = 1; i < len; i++) {
            int left = i - 1;
            while (left >= 0 && heights[left] >= heights[i])
                left = arrLeft[left];
            arrLeft[i] = left;
        }

        int[] arrRight = new int[len];
        arrRight[len - 1] = len;
        for (int i = len - 2; i >= 0; i--) {
            int right = i + 1;
            while (right < len && heights[right] >= heights[i])
                right = arrRight[right];
            arrRight[i] = right;
        }

        int max = 0;
        for (int i = 0; i < len; i++)
            max = Math.max(max, (arrRight[i] - arrLeft[i] - 1) * heights[i]);

        return max;
    }

    @Test
    public void simple1() {
        int expected = 10;
        int[] heights = new int[] { 2, 1, 5, 6, 2, 3 };
        int actual = new Solution().largestRectangleArea(heights);
        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        int expected = 2;
        int[] heights = new int[] { 2 };
        int actual = new Solution().largestRectangleArea(heights);
        assertEquals(expected, actual);
    }

    @Test
    public void simple3() {
        int expected = 16;
        int[] heights = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        int actual = new Solution().largestRectangleArea(heights);
        assertEquals(expected, actual);
    }

    @Test
    public void simple4() {
        int expected = 16;
        int[] heights = new int[] { 7, 6, 5, 4, 3, 2, 1 };
        int actual = new Solution().largestRectangleArea(heights);
        assertEquals(expected, actual);
    }

    @Test
    public void simple5() {
        int expected = 3;
        int[] heights = new int[] { 2, 1, 2 };
        int actual = new Solution().largestRectangleArea(heights);
        assertEquals(expected, actual);
    }

    @Test
    public void simple6() {
        int expected = 0;
        int[] heights = new int[] {};
        int actual = new Solution().largestRectangleArea(heights);
        assertEquals(expected, actual);
    }

    @Test
    public void simple7() {
        int expected = 10;
        int[] heights = new int[] { 4, 2, 0, 3, 2, 4, 3, 4 };
        int actual = new Solution().largestRectangleArea(heights);
        assertEquals(expected, actual);
    }
}
