package kuma.p09.lc0915_Partition_Array_into_Disjoint_Intervals;

public class Solution {
    // Runtime: 2 ms, faster than 62.43% of Java online submissions for Partition
    // Array into Disjoint Intervals.
    // Memory Usage: 44.9 MB, less than 33.33% of Java online submissions for
    // Partition Array into Disjoint Intervals.
    public int partitionDisjoint(int[] A) {
        int n = A.length;
        int[] left = new int[n], right = new int[n];
        left[0] = A[0];
        right[n - 1] = A[n - 1];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], A[i]);
            right[n - i - 1] = Math.min(right[n - i], A[n - i - 1]);
        }

        for (int i = 0; i < n - 1; i++)
            if (left[i] <= right[i + 1])
                return i + 1;

        return 0;
    }
}
