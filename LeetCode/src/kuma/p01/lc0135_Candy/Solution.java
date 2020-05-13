package kuma.p01.lc0135_Candy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Solution {
    // Runtime: 3 ms, faster than 36.35% of Java online submissions for Candy.
    // Memory Usage: 40.8 MB, less than 18.18% of Java online submissions for Candy.
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;
        int n = ratings.length;
        int[] forward = new int[n], backward = new int[n];
        forward[0] = 1;
        backward[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1])
                forward[i] = forward[i - 1] + 1;
            else if (ratings[i] <= ratings[i - 1])
                forward[i] = 1;

            int j = n - i - 1;
            if (ratings[j] > ratings[j + 1])
                backward[j] = backward[j + 1] + 1;
            else if (ratings[j] <= ratings[j + 1])
                backward[j] = 1;
        }
        int res = 0;
        for (int i = 0; i < n; i++)
            res += (Math.max(forward[i], backward[i]));
        return res;
    }

    @Test
    public void simple1() {
        assertEquals(5, new Solution().candy(new int[] { 1, 0, 2 }));
    }

    @Test
    public void simple2() {
        assertEquals(4, new Solution().candy(new int[] { 1, 2, 2 }));
    }

    @Test
    public void simple3() {
        assertEquals(7, new Solution().candy(new int[] { 1, 3, 2, 2, 1 }));
    }

    @Test
    public void simple4() {
        assertEquals(13, new Solution().candy(new int[] { 1, 2, 3, 3, 3, 2, 1 }));
    }
}
