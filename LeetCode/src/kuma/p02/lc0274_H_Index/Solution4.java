package kuma.p02.lc0274_H_Index;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Solution4 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for H-Index.
    // Memory Usage: 37.1 MB, less than 100.00% of Java online submissions for
    // H-Index.
    public int hIndex(int[] citations) {
        int res = 0, n = citations.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int cur = quickSort(citations, left, right);
            if (cur + 1 <= citations[cur]) {
                res = cur + 1;
                left = cur + 1;
            } else
                right = cur - 1;
        }
        return res;
    }

    private int quickSort(int[] arr, int left, int right) {
        if (left == right)
            return right;
        int temp = arr[left], i = left + 1;
        for (int j = left + 1; j <= right; j++)
            if (arr[j] >= temp)
                swap(arr, i++, j);

        swap(arr, left, i - 1);
        return i - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void sapce() {
        assertEquals(0, new Solution4().hIndex(new int[] {}));
    }

    @Test
    public void simple1() {
        assertEquals(3, new Solution4().hIndex(new int[] { 3, 6, 0, 1, 5 }));
    }

    @Test
    public void simple2() {
        assertEquals(0, new Solution4().hIndex(new int[] { 0, 0 }));
    }

    @Test
    public void simple3() {
        assertEquals(1, new Solution4().hIndex(new int[] { 100, 0, 0 }));
    }

    @Test
    public void simple4() {
        assertEquals(1, new Solution4().hIndex(new int[] { 100 }));
    }

    @Test
    public void simple5() {
        assertEquals(0, new Solution4().hIndex(new int[] { 0 }));
    }

    @Test
    public void simple6() {
        assertEquals(1, new Solution4().hIndex(new int[] { 0, 2 }));
    }

    @Test
    public void simple7() {
        assertEquals(1, new Solution4().hIndex(new int[] { 1, 0 }));
    }

    @Test
    public void simple8() {
        assertEquals(1, new Solution4().hIndex(new int[] { 2 }));
    }

    @Test
    public void simple9() {
        assertEquals(2, new Solution4().hIndex(new int[] { 1, 2, 3 }));
    }
}
