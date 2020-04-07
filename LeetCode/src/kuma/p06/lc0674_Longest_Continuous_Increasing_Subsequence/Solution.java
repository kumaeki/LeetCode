package kuma.p06.lc0674_Longest_Continuous_Increasing_Subsequence;

class Solution {
    // Runtime: 2 ms, faster than 8.71% of Java online submissions for Longest
    // Continuous Increasing Subsequence.
    // Memory Usage: 43.3 MB, less than 5.41% of Java online submissions for Longest
    // Continuous Increasing Subsequence.
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int count = 1, max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
                max = Math.max(max, count);
            } else
                count = 1;

        }
        return max;
    }
}