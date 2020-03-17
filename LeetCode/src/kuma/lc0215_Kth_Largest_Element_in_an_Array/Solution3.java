package kuma.lc0215_Kth_Largest_Element_in_an_Array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Solution3 {
    public int findKthLargest(int[] nums, int k) {
        return helper(nums, nums.length - k, 0, nums.length - 1);
    }

    private int helper(int[] nums, int target, int start, int end) {

        swap(nums, start, (start + end) / 2);
        int temp = nums[start];
        int left = start, right = end;
        while (left < right) {
            while (left < right && nums[right] >= temp)
                right--;
            if (left < right)
                nums[left++] = nums[right];
            while (left < right && nums[left] <= temp)
                left++;
            if (left < right)
                nums[right--] = nums[left];
        }
        nums[left] = temp;
        if (left > target) {
            return helper(nums, target, start, left - 1);
        } else if (left < target) {
            return helper(nums, target, left + 1, end);
        } else
            return nums[left];
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void simple1() {
        int expected = 4;
        int[] nums = new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int k = 4;
        int actual = new Solution3().findKthLargest(nums, k);
        assertEquals(expected, actual);
    }

}
