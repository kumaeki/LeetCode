package kuma.p00.lc0081_Search_in_Rotated_Sorted_Array_II;

import java.util.Arrays;

public class Solution2 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in
    // Rotated Sorted Array II.
    // Memory Usage: 39.1 MB, less than 67.60% of Java online submissions for Search
    // in Rotated Sorted Array II.
    class Solution {
        public boolean search(int[] nums, int target) {
            return helper(nums, target, 0, nums.length - 1);
        }

        private boolean helper(int[] nums, int target, int left, int right) {
            if (left > right)
                return false;

            int mid = (left + right) / 2;
            if (nums[left] == target || nums[right] == target || nums[mid] == target)
                return true;

            if (nums[left] < nums[right]) {
                while (left <= right) {
                    mid = (left + right) / 2;
                    if (nums[mid] > target)
                        right = mid - 1;
                    else if (nums[mid] < target)
                        left = mid + 1;
                    else
                        return true;
                }
                return false;
            }

            return helper(nums, target, left, mid - 1) || helper(nums, target, mid + 1, right);
        }
    }
}
