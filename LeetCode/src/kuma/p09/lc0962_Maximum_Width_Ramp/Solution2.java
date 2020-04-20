package kuma.p09.lc0962_Maximum_Width_Ramp;

import java.util.Arrays;

class Solution2 {
    // Runtime: 60 ms, faster than 20.37% of Java online submissions for Maximum
    // Width Ramp.
    // Memory Usage: 55.4 MB, less than 100.00% of Java online submissions for
    // Maximum Width Ramp.
    public int maxWidthRamp(int[] A) {
        int n = A.length;
        Integer[] B = new Integer[n];
        for (int i = 0; i < n; i++)
            B[i] = i;
        Arrays.sort(B, (i, j) -> (A[i] - A[j]));
        int max = 0, min = B[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, B[i] - min);
            min = Math.min(min, B[i]);
        }
        return max;
    }
}
