package kuma.p09.lc0954_Array_of_Doubled_Pairs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

class Solution2 {
    // Runtime: 71 ms, faster than 32.75% of Java online submissions for Array of
    // Doubled Pairs.
    // Memory Usage: 76.9 MB, less than 33.33% of Java online submissions for Array
    // of Doubled Pairs.
    public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int a : A)
            map.put(a, map.getOrDefault(a, 0) + 1);
        // Arrays.sort(A);
        for (int a : map.keySet())
            if (map.get(a) > 0) {
                if (a < 0 && a % 2 == 1)
                    return false;
                int t = a > 0 ? a * 2 : a / 2;
                if (map.getOrDefault(t, 0) < map.get(a))
                    return false;
                map.put(t, map.get(t) - map.get(a));
                // map.put(a, 0);
            }
        return true;
    }

    @Test
    public void simpl1() {
        assertEquals(true, new Solution2().canReorderDoubled(new int[] { 2, 1, 3, 6, 0, 0 }));
    }

    @Test
    public void simpl2() {
        assertEquals(false, new Solution2().canReorderDoubled(new int[] { -3, -5 }));
    }

    @Test
    public void simpl3() {
        assertEquals(true, new Solution2().canReorderDoubled(new int[] { 4, -2, 2, -4 }));
    }
}
