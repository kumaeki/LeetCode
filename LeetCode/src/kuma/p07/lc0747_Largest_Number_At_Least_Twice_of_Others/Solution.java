package kuma.p07.lc0747_Largest_Number_At_Least_Twice_of_Others;

class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Largest
    // Number At Least Twice of Others.
    // Memory Usage: 37.3 MB, less than 82.86% of Java online submissions for
    // Largest Number At Least Twice of Others.
    public int dominantIndex(int[] nums) {
        int max = -1, second = -1, index = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > max) {
                second = max;
                max = num;
                index = i;
            } else if (num < max && num > second) {
                second = num;
            }
        }
        if (max == second || max >= second * 2)
            return index;
        else
            return -1;
    }
}
