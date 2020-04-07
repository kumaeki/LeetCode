package kuma.p06.lc0674_Longest_Continuous_Increasing_Subsequence;

class Solution2 {
    // Runtime: 3 ms, faster than 5.45% of Java online submissions for Longest
    // Continuous Increasing Subsequence.
    // Memory Usage: 43.3 MB, less than 5.41% of Java online submissions for Longest
    // Continuous Increasing Subsequence.
    public int findLengthOfLCIS(int[] nums) {
        int count = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] < nums[i])
                count++;
            else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        return Math.max(max, count);
    }
}