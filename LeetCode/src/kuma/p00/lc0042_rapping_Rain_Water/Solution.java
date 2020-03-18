package kuma.p00.lc0042_rapping_Rain_Water;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class Solution {
    public int trap(int[] height) {
        int res = 0, left = 0, right = height.length - 1;
        int maxL = 0, maxR = 0;
        while (left < right) {
            int hl = height[left], hr = height[right];
            if (hl <= hr) {
                if (hl >= maxL)
                    maxL = hl;
                else
                    res += (maxL - hl);
                left++;
            } else {
                if (hr >= maxR)
                    maxR = hr;
                else
                    res += (maxR - hr);
                right--;
            }
        }

        return res;
    }

    @Test
    public void testSimple1() {
        int expected = 6;
        int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int actual = new Solution().trap(height);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple2() {
        int expected = 2;
        int[] height = new int[] { 2, 0, 2 };
        int actual = new Solution().trap(height);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple4() {
        int expected = 0;
        int[] height = new int[] {};
        int actual = new Solution().trap(height);
        assertEquals(expected, actual);
    }
}
