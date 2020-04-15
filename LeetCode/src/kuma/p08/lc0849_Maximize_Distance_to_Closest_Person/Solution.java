package kuma.p08.lc0849_Maximize_Distance_to_Closest_Person;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution {
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Maximize
    // Distance to Closest Person.
    // Memory Usage: 41.5 MB, less than 8.33% of Java online submissions for
    // Maximize Distance to Closest Person.
    public int maxDistToClosest(int[] seats) {
        int i = 0, j = 0, max = 0, len = seats.length;
        while (j < len) {
            while (j < len && seats[j] == 1)
                j++;
            i = j;
            while (j < len && seats[j] == 0)
                j++;
            if (i == 0 || j == len)
                max = Math.max(max, j - i);
            else
                max = Math.max(max, (j - i + 1) / 2);
        }
        return max;
    }

    @Test
    public void simple1() {
        assertEquals(1, new Solution().maxDistToClosest(new int[] { 0, 1 }));
    }

    @Test
    public void simple2() {
        assertEquals(1, new Solution().maxDistToClosest(new int[] { 1, 1, 1, 1, 0, 1 }));
    }

    @Test
    public void simple3() {
        assertEquals(1, new Solution().maxDistToClosest(new int[] { 1, 0, 1 }));
    }

    @Test
    public void simple4() {
        assertEquals(2, new Solution().maxDistToClosest(new int[] { 1, 0, 0, 0, 0, 1, 1, 1, 0, 1 }));
    }

    @Test
    public void simple5() {
        assertEquals(2, new Solution().maxDistToClosest(new int[] { 1, 0, 0, 0, 1, 1, 1, 0, 1 }));
    }
}
