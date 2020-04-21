package kuma.p09.lc0974_Subarray_Sums_Divisible_by_K;

public class Solution2 {
    // Runtime: 4 ms, faster than 94.78% of Java online submissions for Subarray
    // Sums Divisible by K.
    // Memory Usage: 42.6 MB, less than 52.63% of Java online submissions for
    // Subarray Sums Divisible by K.
    public int subarraysDivByK(int[] A, int K) {
        int res = 0, sum = 0;
        int[] arr = new int[K];
        arr[0] = 1;
        for (int a : A) {
            sum = (sum + a % K + K) % K;
            res += arr[sum];
            arr[sum]++;
        }
        return res;
    }
}
