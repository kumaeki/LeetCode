package kuma.p02.lc0215_Kth_Largest_Element_in_an_Array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Solution4 {
    public int findKthLargest(int[] nums, int k) {
        return helper(nums, nums.length - k, 0, nums.length - 1);
    }

    private int helper(int[] nums, int target, int start, int end) {

        swap(nums, end, (start + end) / 2);
        int index = start;
        for(int i = start; i < end; i++) {
            if(nums[i] <= nums[end])
                swap(nums, i, index++);
        }
        swap(nums, index, end);
        
        if (index > target) {
            return helper(nums, target, start, index - 1);
        } else if (index < target) {
            return helper(nums, target, index + 1, end);
        } else
            return nums[index];
    }

    private void swap(int[] nums, int i, int j) {
        if(i == j)
            return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void simple1() {
        int expected = 4;
        int[] nums = new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int k = 4;
        int actual = new Solution4().findKthLargest(nums, k);
        assertEquals(expected, actual);
    }

}
