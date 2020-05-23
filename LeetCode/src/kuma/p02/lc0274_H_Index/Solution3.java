package kuma.p02.lc0274_H_Index;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Solution3 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for H-Index.
    // Memory Usage: 37.2 MB, less than 100.00% of Java online submissions for
    // H-Index.
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] arr = new int[n + 1];
        for (int cit : citations)
            if (cit >= n)
                arr[n]++;
            else
                arr[cit]++;

        int count = 0;
        for (int i = n; i >= 0; i++) {
            count += arr[i];
            if (i <= count)
                return i;
        }
        return 0;
    }

    @Test
    public void simple1() {
        assertEquals(3, new Solution3().hIndex(new int[] { 3, 6, 0, 1, 5 }));
    }

    @Test
    public void simple2() {
        assertEquals(0, new Solution3().hIndex(new int[] { 0, 0 }));
    }

    @Test
    public void simple3() {
        assertEquals(1, new Solution3().hIndex(new int[] { 100, 0, 0 }));
    }
}
