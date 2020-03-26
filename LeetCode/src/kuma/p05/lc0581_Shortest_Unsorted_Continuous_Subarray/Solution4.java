package kuma.p05.lc0581_Shortest_Unsorted_Continuous_Subarray;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class Solution4 {
    // Runtime: 1 ms, faster than 100.00%
    public int findUnsortedSubarray(int[] nums) {
        int left = -2, right = -2, max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[max]) {
                right = i;
                if (left == -2)
                    left = max;
                while (left >= 0 && nums[left] > nums[i])
                    left--;

            }
            if (nums[i] > nums[max])
                max = i;
        }
        return right - left;
    }

    @Test
    public void simple1() {
        int expected = 5;
        int[] nums = new int[] { 2, 6, 4, 8, 10, 9, 15 };
        int actual = new Solution4().findUnsortedSubarray(nums);

        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        int expected = 5;
        int[] nums = new int[] { 2, 1, 1, 1, 1 };
        int actual = new Solution4().findUnsortedSubarray(nums);

        assertEquals(expected, actual);
    }

    @Test
    public void simple3() {
        int expected = 0;
        int[] nums = new int[] {};
        int actual = new Solution4().findUnsortedSubarray(nums);

        assertEquals(expected, actual);
    }

    @Test
    public void simple4() {
        int expected = 4;
        int[] nums = new int[] { 3, 2, 3, 2, 4 };
        int actual = new Solution4().findUnsortedSubarray(nums);

        assertEquals(expected, actual);
    }

    @Test
    public void simple5() {
        int expected = 3;
        int[] nums = new int[] { 1, 2, 4, 5, 3 };
        int actual = new Solution4().findUnsortedSubarray(nums);

        assertEquals(expected, actual);
    }

    @Test
    public void simple6() {
        int expected = 5;
        int[] nums = new int[] { 2, 1, 3, 5, 4 };
        int actual = new Solution4().findUnsortedSubarray(nums);

        assertEquals(expected, actual);
    }
}
