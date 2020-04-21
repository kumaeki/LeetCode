package kuma.p09.lc0974_Subarray_Sums_Divisible_by_K;

public class Solution3 {
    // Runtime: 5 ms, faster than 83.76% of Java online submissions for Subarray
    // Sums Divisible by K.
    // Memory Usage: 40.1 MB, less than 100.00% of Java online submissions for
    // Subarray Sums Divisible by K.
    public int subarraysDivByK(int[] A, int K) {
        int res = 0, n = A.length;
        int[] preSum = new int[n];
        preSum[0] = A[0];
        for (int i = 1; i < n; i++)
            preSum[i] = preSum[i - 1] + A[i];

        int[] arr = new int[K];
        for (int s : preSum)
            arr[(s % K + K) % K]++;

        for (int a : arr)
            res += (a * (a - 1) / 2);

        return res;
    }
}
