package kuma.p09.lc0945_Minimum_Increment_to_Make_Array_Unique;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Solution2 {
    // Runtime: 3 ms, faster than 98.63% of Java online submissions for Minimum
    // Increment to Make Array Unique.
    // Memory Usage: 54.2 MB, less than 16.67% of Java online submissions for
    // Minimum Increment to Make Array Unique.
    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length < 2)
            return 0;

        int max = 0, res = 0, pre = -1;
        for (int a : A)
            if (max < a)
                max = a;
        int[] arr = new int[max + 1];
        for (int a : A)
            arr[a]++;
        for (int i = 0; i <= max; i++) {
            int count = arr[i];
            if (count > 0) {
                if (pre == -1) {
                    res += count * (count - 1) / 2;
                    pre = i + count - 1;
                } else {
                    if (i > pre) {
                        res += count * (count - 1) / 2;
                        pre = i + count - 1;
                    } else {
                        res += count * (pre - i + 1) + count * (count - 1) / 2;
                        pre = (pre + count);
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void simple1() {
        assertEquals(1, new Solution2().minIncrementForUnique(new int[] { 1, 2, 2 }));
    }

    @Test
    public void simple2() {
        assertEquals(6, new Solution2().minIncrementForUnique(new int[] { 1, 1, 2, 2, 3, 7 }));
    }

    @Test
    public void simple3() {
        assertEquals(3, new Solution2().minIncrementForUnique(new int[] { 1, 2, 2, 2 }));
    }
}
