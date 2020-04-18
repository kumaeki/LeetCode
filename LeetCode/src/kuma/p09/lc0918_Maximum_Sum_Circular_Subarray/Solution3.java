package kuma.p09.lc0918_Maximum_Sum_Circular_Subarray;

public class Solution3 {
    // Runtime: 3 ms, faster than 88.82% of Java online submissions for Maximum Sum
    // Circular Subarray.
    // Memory Usage: 46.1 MB, less than 10.00% of Java online submissions for
    // Maximum Sum Circular Subarray.
    public int maxSubarraySumCircular(int[] A) {
        int res = A[0], cur = A[0], n = A.length;
        // one-interval subarrays
        for (int i = 1; i < n; i++) {
            cur = A[i] + Math.max(cur, 0);
            res = Math.max(res, cur);
        }

        // two-interval subarrays
        int[] sumR = new int[n];
        sumR[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--)
            sumR[i] = sumR[i + 1] + A[i];

        int[] maxR = new int[n];
        maxR[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--)
            maxR[i] = Math.max(maxR[i + 1], sumR[i]);

        int sumL = 0;
        for (int i = 0; i < n - 2; i++) {
            sumL += A[i];
            res = Math.max(res, sumL + maxR[i + 2]);
        }

        return res;
    }
}
