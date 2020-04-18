package kuma.p09.lc0918_Maximum_Sum_Circular_Subarray;

public class Solution2 {
    // Runtime: 4 ms, faster than 73.53% of Java online submissions for Maximum Sum
    // Circular Subarray.
    // Memory Usage: 45.7 MB, less than 10.00% of Java online submissions for
    // Maximum Sum Circular Subarray.
    public int maxSubarraySumCircular(int[] A) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int total = 0, curMax = 0, curMin = 0;

        for (int a : A) {
            total += a;
            curMax = Math.max(curMax + a, a);
            curMin = Math.min(curMin + a, a);
            max = Math.max(curMax, max);
            min = Math.min(curMin, min);
        }

        return max > 0 ? Math.max(total - min, max) : max;
    }
}
