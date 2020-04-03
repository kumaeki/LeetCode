package kuma.p05.lc0581_Shortest_Unsorted_Continuous_Subarray;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class Solution5 {
    // Runtime: 2 ms, faster than 77.99% of Java online submissions for Shortest
    // Unsorted Continuous Subarray.
    // Memory Usage: 40.7 MB, less than 88.46% of Java online submissions for
    // Shortest Unsorted Continuous Subarray.
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        Integer valley = null, peak = null;
        for (int i = 1; i < len; i++)
            if (nums[i] < nums[i - 1])
                valley = valley == null ? nums[i] : Math.min(valley, nums[i]);

        for (int i = len - 2; i >= 0; i--)
            if (nums[i] > nums[i + 1])
                peak = peak == null ? nums[i] : Math.max(peak, nums[i]);

        if (valley == null)
            return 0;

        int left = 0, right = len - 1;
        while (left <= right && nums[left] <= valley)
            left++;
        while (left <= right && nums[right] >= peak)
            right--;

        return right - left + 1;
    }

    @Test
    public void simple1() {
        int expected = 5;
        int[] nums = new int[] { 2, 6, 4, 8, 10, 9, 15 };
        int actual = new Solution5().findUnsortedSubarray(nums);

        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        int expected = 5;
        int[] nums = new int[] { 2, 1, 1, 1, 1 };
        int actual = new Solution5().findUnsortedSubarray(nums);

        assertEquals(expected, actual);
    }

    @Test
    public void simple3() {
        int expected = 0;
        int[] nums = new int[] {};
        int actual = new Solution5().findUnsortedSubarray(nums);

        assertEquals(expected, actual);
    }

    @Test
    public void simple4() {
        int expected = 4;
        int[] nums = new int[] { 3, 2, 3, 2, 4 };
        int actual = new Solution5().findUnsortedSubarray(nums);

        assertEquals(expected, actual);
    }

    @Test
    public void simple5() {
        int expected = 3;
        int[] nums = new int[] { 1, 2, 4, 5, 3 };
        int actual = new Solution5().findUnsortedSubarray(nums);

        assertEquals(expected, actual);
    }

    @Test
    public void simple6() {
        int expected = 5;
        int[] nums = new int[] { 2, 1, 3, 5, 4 };
        int actual = new Solution5().findUnsortedSubarray(nums);

        assertEquals(expected, actual);
    }
}
