package kuma.p07.lc0775_Global_and_Local_Inversions;

public class Solution {
    // Runtime: 1 ms, faster than 95.03% of Java online submissions for Global and
    // Local Inversions.
    // Memory Usage: 40.1 MB, less than 100.00% of Java online submissions for
    // Global and Local Inversions.
    public boolean isIdealPermutation(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (Math.abs(A[i] - i) > 1)
                return false;
        }
        return true;
    }
}
