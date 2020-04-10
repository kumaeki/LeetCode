package kuma.p07.lc0768_Max_Chunks_To_Make_Sorted_II;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.Test;

public class Solution {
    // Runtime: 7 ms, faster than 20.66% of Java online submissions for Max Chunks
    // To Make Sorted II.
    // Memory Usage: 39.7 MB, less than 92.86% of Java online submissions for Max
    // Chunks To Make Sorted II.
    public int maxChunksToSorted(int[] arr) {
        int len = arr.length, res = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(len);
        int[] expected = arr.clone();
        Arrays.sort(expected);
        for (int i = 0; i < len; i++) {
            int ori = arr[i], exp = expected[i];
            map.put(ori, map.getOrDefault(ori, 0) + 1);
            if (map.get(ori) == 0)
                count--;
            else if (map.get(ori) == 1)
                count++;

            map.put(exp, map.getOrDefault(exp, 0) - 1);
            if (map.get(exp) == 0)
                count--;
            else if (map.get(exp) == -1)
                count++;

            if (count == 0)
                res++;
        }
        return res;
    }

    @Test
    public void simple1() {
        assertEquals(1, new Solution().maxChunksToSorted(new int[] { 4, 2, 2, 1, 1 }));
    }

    @Test
    public void simple2() {
        assertEquals(1, new Solution().maxChunksToSorted(new int[] { 4, 4, 4, 4, 4, 2, 2, 2, 2, 1, 1, 1, 1, 1 }));
    }
}
