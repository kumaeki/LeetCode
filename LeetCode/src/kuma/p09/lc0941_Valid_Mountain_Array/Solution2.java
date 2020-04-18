package kuma.p09.lc0941_Valid_Mountain_Array;

public class Solution2 {
    // Runtime: 2 ms, faster than 30.30% of Java online submissions for Valid
    // Mountain Array.
    // Memory Usage: 40.3 MB, less than 100.00% of Java online submissions for Valid
    // Mountain Array.

    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3)
            return false;
        int isIncreasing = -1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1])
                return false;

            if (isIncreasing == -1)
                if (A[i] > A[i - 1])
                    isIncreasing = 0;
                else
                    return false;
            else if (isIncreasing == 0 && A[i] < A[i - 1])
                isIncreasing = 1;
            else if (isIncreasing == 1 && A[i] > A[i - 1])
                return false;
        }
        return isIncreasing == 1;
    }
}
