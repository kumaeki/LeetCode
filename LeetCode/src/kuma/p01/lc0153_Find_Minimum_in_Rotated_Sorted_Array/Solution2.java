package kuma.p01.lc0153_Find_Minimum_in_Rotated_Sorted_Array;

public class Solution2 {
    // Runtime: 0 ms, faster than 100.00%
    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public int helper(int[] nums, int start, int end) {
        if (start == end)
            return nums[end];

        int mid = (start + end) / 2;
        if (nums[mid] > nums[end])
            return helper(nums, mid + 1, end);
        else
            return helper(nums, start, mid);
    }
}
