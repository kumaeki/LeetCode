package kuma.p09.lc0977_Squares_of_a_Sorted_Array;

import static org.junit.Assert.assertArrayEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

public class Solution2 {
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Squares of
    // a Sorted Array.
    // Memory Usage: 41.6 MB, less than 95.12% of Java online submissions for
    // Squares of a Sorted Array.
    public int[] sortedSquares(int[] A) {
        int j = Arrays.binarySearch(A, 0), n = A.length, index = 0;
        int[] res = new int[n];
        if (j < 0)
            j = -j - 1;
        int i = j - 1, left, right;
        while (i >= 0 && j < n) {
            left = -A[i];
            right = A[j];
            if (left > right) {
                res[index++] = right * right;
                j++;
            } else {
                res[index++] = left * left;
                i--;
            }
        }
        while (i >= 0) {
            left = A[i--];
            res[index++] = left * left;
        }
        while (j < n) {
            right = A[j++];
            res[index++] = right * right;
        }
        return res;
    }

    @Test
    public void simple1() {
        assertArrayEquals(new int[] { 1 }, new Solution2().sortedSquares(new int[] { -1 }));
    }
}
