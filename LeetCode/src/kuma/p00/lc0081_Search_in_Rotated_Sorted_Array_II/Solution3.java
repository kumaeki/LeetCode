package kuma.p00.lc0081_Search_in_Rotated_Sorted_Array_II;

public class Solution3 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in
    // Rotated Sorted Array II.
    // Memory Usage: 39.1 MB, less than 67.60% of Java online submissions for Search
    // in Rotated Sorted Array II.
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] == target || nums[right] == target)
                return true;
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[mid] > nums[left]) {
                if (nums[left] < target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else if (nums[mid] < nums[left]) {
                if (nums[mid] < target && target < nums[left])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else
                left++;
        }
        return false;
    }

}
