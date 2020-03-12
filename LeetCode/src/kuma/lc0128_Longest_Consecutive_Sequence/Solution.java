package kuma.lc0128_Longest_Consecutive_Sequence;

import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length < 2)
            return nums.length;

        Arrays.sort(nums);
        int res = 0, max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1)
                max++;
            else if (nums[i] != nums[i - 1]) {
                res = Math.max(res, max);
                max = 1;
            }

        }
        return Math.max(res, max);
    }
}
