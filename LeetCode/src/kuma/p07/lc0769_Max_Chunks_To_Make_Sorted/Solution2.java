package kuma.p07.lc0769_Max_Chunks_To_Make_Sorted;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution2 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Max Chunks
    // To Make Sorted.
    // Memory Usage: 36.5 MB, less than 10.00% of Java online submissions for Max
    // Chunks To Make Sorted.
    public int maxChunksToSorted(int[] arr) {
        int res = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == arr[i])
                res++;
        }
        return res;
    }

    @Test
    public void simple1() {
        assertEquals(2, new Solution2().maxChunksToSorted(new int[] { 0, 4, 5, 2, 1, 3 }));
    }

    @Test
    public void simple2() {
        assertEquals(3, new Solution2().maxChunksToSorted(new int[] { 1, 2, 0, 3, 4 }));
    }
}
