package kuma.p00.lc0042_rapping_Rain_Water;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Stack;

import org.junit.Test;

public class Solution4 {
    public int trap(int[] height) {
        int res = 0, len = height.length;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int low = stack.pop();
                if (!stack.isEmpty()) {
                    int w = i - stack.peek() - 1;
                    res += (Math.min(height[i], height[stack.peek()]) - height[low]) * w;
                }
            }
            stack.push(i);
        }

        return res;
    }

    @Test
    public void testSimple1() {
        int expected = 6;
        int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int actual = new Solution4().trap(height);
        assertEquals(expected, actual);
    }
}
