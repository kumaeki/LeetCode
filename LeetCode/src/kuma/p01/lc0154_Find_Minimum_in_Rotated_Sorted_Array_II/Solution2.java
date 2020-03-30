package kuma.p01.lc0154_Find_Minimum_in_Rotated_Sorted_Array_II;

public class Solution2 {
    // Runtime: 0 ms, faster than 100.00%
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        while(start < end && nums[start] >= nums[end]) {
            int mid = (start + end) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;;
            } else if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                start++;
            }
        }
        return nums[start];
    }
}
