package kuma.p08.lc0870_Advantage_Shuffle;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class Solution {
    // Runtime: 1426 ms, faster than 5.19% of Java online submissions for Advantage
    // Shuffle.
    // Memory Usage: 43.1 MB, less than 58.33% of Java online submissions for
    // Advantage Shuffle.
    public int[] advantageCount(int[] A, int[] B) {
        int n = A.length;
        int[] index = new int[n], res = new int[n];
        for (int i = 0; i < n; i++)
            index[i] = i;
        Arrays.sort(A);
        sort(B, index, n);
        if (A[0] > B[index[n - 1]] && A[n - 1] < B[index[0]])
            return A;
        boolean flg = true;
        for (int i = 0, j = 0; i < n; i++) {
            while (flg && A[j] <= B[index[i]]) {
                j++;
                if (j == n) {
                    j = 0;
                    flg = false;
                }
            }
            while (A[j] == Integer.MIN_VALUE)
                j++;
            res[index[i]] = A[j];
            A[j] = Integer.MIN_VALUE;
        }
        return res;
    }

    private void sort(int[] arr, int[] index, int n) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[index[j]] > arr[index[j + 1]]) {
                    int temp = index[j];
                    index[j] = index[j + 1];
                    index[j + 1] = temp;
                }
    }

    @Test
    public void simple1() {
        assertArrayEquals(new int[] { 24, 32, 8, 12 },
                new Solution().advantageCount(new int[] { 12, 24, 8, 32 }, new int[] { 13, 25, 32, 11 }));
    }

    @Test
    public void simple2() {
        assertArrayEquals(new int[] { 2, 11, 7, 15 },
                new Solution().advantageCount(new int[] { 2, 7, 11, 15 }, new int[] { 1, 10, 4, 11 }));
    }

    @Test
    public void simple3() {
        assertArrayEquals(new int[] { 2, 0, 2, 1, 4 },
                new Solution().advantageCount(new int[] { 2, 0, 4, 1, 2 }, new int[] { 1, 3, 0, 0, 2 }));
    }
}
