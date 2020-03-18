package kuma.p00.lc0084_Largest_Rectangle_in_Histogram;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Stack;

import org.junit.jupiter.api.Test;

class Solution3 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;

        int len = heights.length;
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        for (int i = 0; i <= len; i++) {
            int h = i == len ? 0 : heights[i];
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int top = stack.pop();
                res = Math.max(res, heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1));
                i--;
            }
        }

        return res;
    }

    @Test
    public void simple1() {
        int expected = 10;
        int[] heights = new int[] { 2, 1, 5, 6, 2, 3 };
        int actual = new Solution3().largestRectangleArea(heights);
        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        int expected = 2;
        int[] heights = new int[] { 2 };
        int actual = new Solution3().largestRectangleArea(heights);
        assertEquals(expected, actual);
    }

    @Test
    public void simple3() {
        int expected = 16;
        int[] heights = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        int actual = new Solution3().largestRectangleArea(heights);
        assertEquals(expected, actual);
    }

    @Test
    public void simple4() {
        int expected = 16;
        int[] heights = new int[] { 7, 6, 5, 4, 3, 2, 1 };
        int actual = new Solution3().largestRectangleArea(heights);
        assertEquals(expected, actual);
    }

    @Test
    public void simple5() {
        int expected = 3;
        int[] heights = new int[] { 2, 1, 2 };
        int actual = new Solution3().largestRectangleArea(heights);
        assertEquals(expected, actual);
    }

    @Test
    public void simple6() {
        int expected = 0;
        int[] heights = new int[] {};
        int actual = new Solution3().largestRectangleArea(heights);
        assertEquals(expected, actual);
    }

    @Test
    public void simple7() {
        int expected = 10;
        int[] heights = new int[] { 4, 2, 0, 3, 2, 4, 3, 4 };
        int actual = new Solution3().largestRectangleArea(heights);
        assertEquals(expected, actual);
    }
}
