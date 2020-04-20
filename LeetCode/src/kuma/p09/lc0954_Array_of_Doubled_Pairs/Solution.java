package kuma.p09.lc0954_Array_of_Doubled_Pairs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Solution {
    // Runtime: 9 ms, faster than 97.39% of Java online submissions for Array of
    // Doubled Pairs.
    // Memory Usage: 72.2 MB, less than 33.33% of Java online submissions for Array
    // of Doubled Pairs.
    public boolean canReorderDoubled(int[] A) {
        int max = 0, min = 0;
        for (int a : A) {
            max = Math.max(max, a);
            min = Math.min(min, a);
        }
        int[] neg = new int[-min + 1], pos = new int[max + 1];
        int count0 = 0;
        for (int a : A) {
            if (a > 0)
                pos[a]++;
            else if (a < 0)
                neg[-a]++;
            else
                count0++;
        }

        if (count0 % 2 == 1)
            return false;
        for (int i = 0, mid = max / 2; i <= max; i++)
            if (pos[i] > 0)
                if (i > mid || pos[i * 2] < pos[i])
                    return false;
                else {
                    pos[i * 2] -= pos[i];
                    pos[i] = 0;
                }

        for (int i = 0, mid = -min / 2; i <= -min; i++)
            if (neg[i] > 0)
                if (i > mid || neg[i * 2] < neg[i])
                    return false;
                else {
                    neg[i * 2] -= neg[i];
                    neg[i] = 0;
                }

        return true;
    }

    @Test
    public void simpl1() {
        assertEquals(true, new Solution().canReorderDoubled(new int[] { 2, 1, 3, 6, 0, 0 }));
    }

    @Test
    public void simpl2() {
        assertEquals(false, new Solution().canReorderDoubled(new int[] { -3, -5 }));
    }

    @Test
    public void simpl3() {
        assertEquals(true, new Solution().canReorderDoubled(new int[] { 4, -2, 2, -4 }));
    }
}
