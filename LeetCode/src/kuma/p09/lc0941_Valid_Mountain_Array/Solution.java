package kuma.p09.lc0941_Valid_Mountain_Array;

public class Solution {
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Valid
    // Mountain Array.
    // Memory Usage: 39.6 MB, less than 100.00% of Java online submissions for Valid
    // Mountain Array.

    public boolean validMountainArray(int[] A) {
        int n = A.length, i = 1;
        while (i < n && A[i] > A[i - 1])
            i++;
        if (i == 1 || i == n)
            return false;
        while (i < n && A[i] < A[i - 1])
            i++;
        return i == n;
    }
}
