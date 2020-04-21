package kuma.p09.lc0969_Pancake_Sorting;

import static org.junit.Assert.assertArrayEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

public class Solution {
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Pancake
    // Sorting.
    // Memory Usage: 39.1 MB, less than 5.26% of Java online submissions for Pancake
    // Sorting.
    public List<Integer> pancakeSort(int[] A) {
        int n = A.length;
        List<Integer> list = new ArrayList<Integer>();
        for (int t = n; t > 0; t--) {
            int i = 0;
            while (i < t && A[i] != t)
                i++;
            if (i + 1 == t)
                continue;
            if (i == 0) {
                list.add(t);
                sort(A, t - 1);
            } else {
                list.add(i + 1);
                list.add(t);
                sort(A, i);
                sort(A, t - 1);
            }
        }
        return list;
    }

    private void sort(int[] A, int k) {
        int left = 0, right = k, temp;
        while (left < right) {
            temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left++;
            right--;
        }
    }

    @Test
    public void simple1() {
        assertArrayEquals(new Integer[] { 4, 2, 4, 3 },
                new Solution().pancakeSort(new int[] { 3, 2, 4, 1 }).toArray(new Integer[4]));
    }
}
