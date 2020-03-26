package kuma.p05.lc0581_Shortest_Unsorted_Continuous_Subarray;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution2 {
    // Runtime: 2 ms, faster than 79.07%
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int left = -1, right = -2, max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                if (nums[i] < max)
                    right = i;
            } else {
                right = i;
                if (left == -1)
                    left = i - 1;
                for (int j = left; j >= 0; j--) {
                    if (nums[i] < nums[j])
                        left = j;
                    else
                        break;
                }
            }
            max = Math.max(max, nums[i]);
        }
        return right - left + 1;
    }

    @Test
    public void simple1() {
        int expected = 5;
        int[] nums = new int[] { 2, 6, 4, 8, 10, 9, 15 };
        int actual = new Solution2().findUnsortedSubarray(nums);

        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        int expected = 5;
        int[] nums = new int[] { 2, 1, 1, 1, 1 };
        int actual = new Solution2().findUnsortedSubarray(nums);

        assertEquals(expected, actual);
    }

    @Test
    public void simple3() {
        int expected = 0;
        int[] nums = new int[] {};
        int actual = new Solution().findUnsortedSubarray(nums);

        assertEquals(expected, actual);
    }
}
