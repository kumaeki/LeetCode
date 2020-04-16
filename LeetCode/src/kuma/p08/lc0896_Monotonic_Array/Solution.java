package kuma.p08.lc0896_Monotonic_Array;

public class Solution {
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Monotonic
    // Array.
    // Memory Usage: 47.7 MB, less than 100.00% of Java online submissions for
    // Monotonic Array.
    public boolean isMonotonic(int[] A) {
        int dif = 0;
        for (int i = 1; i < A.length; i++) {
            if (dif == 0)
                dif = A[i] - A[i - 1];
            else if ((A[i] - A[i - 1]) * dif < 0)
                return false;
        }
        return true;
    }
}
