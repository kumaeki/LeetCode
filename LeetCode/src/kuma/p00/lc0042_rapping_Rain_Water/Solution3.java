package kuma.p00.lc0042_rapping_Rain_Water;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution3 {
    public int trap(int[] height) {
        if(height == null || height.length <3)
            return 0;
        
        int res = 0, len = height.length;
        int[] left = new int[len], right = new int[len];

        left[0] = height[0];
        for (int i = 1; i < len; i++)
            left[i] = Math.max(left[i - 1], height[i]);

        right[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--)
            right[i] = Math.max(right[i + 1], height[i]);

        for (int i = 0; i < len; i++)
            res += (Math.min(left[i], right[i]) - height[i]);

        return res;
    }

    @Test
    public void testSimple1() {
        int expected = 6;
        int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int actual = new Solution3().trap(height);
        assertEquals(expected, actual);
    }
}
