package kuma.p00.lc0081_Search_in_Rotated_Sorted_Array_II;

public class Solution {
    public boolean search(int[] nums, int target) {
        for (int num : nums)
            if (num == target)
                return true;
        return false;
    }
}
