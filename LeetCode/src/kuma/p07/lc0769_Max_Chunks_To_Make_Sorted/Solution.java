package kuma.p07.lc0769_Max_Chunks_To_Make_Sorted;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Max Chunks
    // To Make Sorted.
    // Memory Usage: 36.5 MB, less than 10.00% of Java online submissions for Max
    // Chunks To Make Sorted.
    public int maxChunksToSorted(int[] arr) {
        int len = arr.length, index = 0, res = len;
        while (index < len) {
            if (arr[index] <= index)
                index++;
            else {
                int i = index, max = arr[index];
                while (i <= max && max < len - 1) {
                    if (arr[i] > max)
                        max = arr[i];
                    i++;
                }
                res -= (max - index);
                index = max;
            }
        }
        return res;
    }

    @Test
    public void simple1() {
        assertEquals(2, new Solution().maxChunksToSorted(new int[] { 0, 4, 5, 2, 1, 3 }));
    }

    @Test
    public void simple2() {
        assertEquals(3, new Solution().maxChunksToSorted(new int[] { 1, 2, 0, 3, 4 }));
    }
}
