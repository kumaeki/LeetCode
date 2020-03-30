package kuma.p01.lc0153_Find_Minimum_in_Rotated_Sorted_Array;

public class Solution3 {
    // Runtime: 0 ms, faster than 100.00%
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[end])
                start = mid + 1;
            else
                end = mid;
        }
        return nums[end];
    }
}
