package kuma.p09.lc0962_Maximum_Width_Ramp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Solution3 {
    // Runtime: 1261 ms, faster than 9.16% of Java online submissions for Maximum
    // Width Ramp.
    // Memory Usage: 52.2 MB, less than 100.00% of Java online submissions for
    // Maximum Width Ramp.
    public int maxWidthRamp(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        for (int i = 0; i < n; i++)
            B[i] = i;
        sort(A, B, 0, n - 1);
        int max = 0, min = B[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, B[i] - min);
            min = Math.min(min, B[i]);
        }
        return max;
    }

    private void sort(int[] A, int[] B, int start, int end) {
        if (start < end) {
            int temp = A[B[start]];
            int index = start + 1;
            for (int i = start + 1; i <= end; i++) {
                if (A[B[i]] < temp || (A[B[i]] == temp && B[i] < B[start])) {
                    swap(B, i, index);
                    index++;
                }
            }
            swap(B, start, index - 1);
            sort(A, B, start, index - 2);
            sort(A, B, index, end);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void simple1() {
        assertEquals(1, new Solution3().maxWidthRamp(new int[] { 1, 1 }));
    }

    @Test
    public void simple2() {
        assertEquals(0, new Solution3().maxWidthRamp(new int[] { 4, 3, 2, 1 }));
    }

    @Test
    public void simple3() {
        assertEquals(3, new Solution3().maxWidthRamp(new int[] { 9, 1, 1, 9 }));
    }
}
