package kuma.lc0042_rapping_Rain_Water;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution2 {
    public int trap(int[] height) {
        int res = 0, sum = 0;
        int left = 0;

        for (int i = 1; i < height.length; i++) {
            if (height[i] < height[left]) {
                sum += (height[left] - height[i]);
            } else {
                res += sum;
                sum = 0;
                left = i;
            }
        }

        sum = 0;
        int right = height.length - 1;
        for (int j = height.length - 2; j >= 0; j--) {
            if (height[j] <= height[right])
                sum += (height[right] - height[j]);
            else {
                res += sum;
                sum = 0;
                right = j;
            }
        }
        return res;
    }

    @Test
    public void testSimple1() {
        int expected = 6;
        int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int actual = new Solution2().trap(height);
        assertEquals(expected, actual);
    }
}
