package kuma.lc0084_Largest_Rectangle_in_Histogram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Solution2 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            int h = heights[i];
            int left = i - 1, right = i + 1;
            while (left >= 0 && heights[left] >= h)
                left--;
            while (right < len && heights[right] >= h)
                right++;
            max = Math.max(max, (right - left - 1) * h);
        }
        return max;
    }

    @Test
    public void simple1() {
        int expected = 10;
        int[] heights = new int[] { 2, 1, 5, 6, 2, 3 };
        int actual = new Solution2().largestRectangleArea(heights);
        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        int expected = 2;
        int[] heights = new int[] { 2 };
        int actual = new Solution2().largestRectangleArea(heights);
        assertEquals(expected, actual);
    }

    @Test
    public void simple3() {
        int expected = 16;
        int[] heights = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        int actual = new Solution2().largestRectangleArea(heights);
        assertEquals(expected, actual);
    }

    @Test
    public void simple4() {
        int expected = 16;
        int[] heights = new int[] { 7, 6, 5, 4, 3, 2, 1 };
        int actual = new Solution2().largestRectangleArea(heights);
        assertEquals(expected, actual);
    }

    @Test
    public void simple5() {
        int expected = 3;
        int[] heights = new int[] { 2, 1, 2 };
        int actual = new Solution2().largestRectangleArea(heights);
        assertEquals(expected, actual);
    }
}
