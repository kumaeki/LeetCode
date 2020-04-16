package kuma.p08.lc0891_Sum_of_Subsequence_Widths;

import java.util.Arrays;

public class Solution {
    // Runtime: 14 ms, faster than 92.00% of Java online submissions for Sum of
    // Subsequence Widths.
    // Memory Usage: 41.7 MB, less than 100.00% of Java online submissions for Sum
    // of Subsequence Widths.
    public int sumSubseqWidths(int[] A) {
        Arrays.sort(A);
        long res = 0;
        int n = A.length;
        long[] pow = new long[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++)
            pow[i] = (pow[i - 1] * 2) % 1_000_000_007;

        for (int i = 0; i < n; i++)
            res = (res + (pow[i] - pow[n - i - 1]) * A[i]) % 1_000_000_007;

        return (int) res;
    }
}
