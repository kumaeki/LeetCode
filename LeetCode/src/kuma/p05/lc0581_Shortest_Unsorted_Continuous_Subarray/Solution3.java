package kuma.p05.lc0581_Shortest_Unsorted_Continuous_Subarray;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Solution3 {
    // Runtime: 6 ms, faster than 56.15%
    public int findUnsortedSubarray(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            arr[i] = nums[i];
        Arrays.sort(arr);
        int left = 0, right = nums.length - 1;
        while (left <= right && arr[left] == nums[left])
            left++;
        while (left <= right && arr[right] == nums[right])
            right--;
        return right - left + 1;
    }

    @Test
    public void simple1() {
        int expected = 5;
        int[] nums = new int[] { 2, 6, 4, 8, 10, 9, 15 };
        int actual = new Solution3().findUnsortedSubarray(nums);

        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        int expected = 5;
        int[] nums = new int[] { 2, 1, 1, 1, 1 };
        int actual = new Solution3().findUnsortedSubarray(nums);

        assertEquals(expected, actual);
    }

    @Test
    public void simple3() {
        int expected = 0;
        int[] nums = new int[] {};
        int actual = new Solution3().findUnsortedSubarray(nums);

        assertEquals(expected, actual);
    }

    @Test
    public void simple4() {
        int expected = 4;
        int[] nums = new int[] { 3, 2, 3, 2, 4 };
        int actual = new Solution3().findUnsortedSubarray(nums);

        assertEquals(expected, actual);
    }
}
