package kuma.p06.lc0643_Maximum_Average_Subarray_I;

public class Solution {
    // Runtime: 2 ms, faster than 91.11% of Java online submissions for Maximum
    // Average Subarray I.
    // Memory Usage: 43.7 MB, less than 23.08% of Java online submissions for
    // Maximum Average Subarray I.
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0, count = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            count++;
            if (count == k) {
                max = Math.max(max, sum);
                sum -= nums[i + 1 - k];
                count--;
            }
        }
        return max / (double) k;
    }
}
