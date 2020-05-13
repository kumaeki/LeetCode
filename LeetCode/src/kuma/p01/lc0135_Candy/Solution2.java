package kuma.p01.lc0135_Candy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Solution2 {
    // Runtime: 2 ms, faster than 97.33% of Java online submissions for Candy.
    // Memory Usage: 41 MB, less than 9.09% of Java online submissions for Candy.
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
            else
                forward[i] = 1;

            int j = n - i - 1;
            if (ratings[j] > ratings[j + 1])
                backward[j] = backward[j + 1] + 1;
            else
                backward[j] = 1;
        }
        int res = 0;
        for (int i = 0; i < n; i++)
            res += (Math.max(forward[i], backward[i]));
        return res;
    }

    @Test
    public void simple1() {
        assertEquals(5, new Solution2().candy(new int[] { 1, 0, 2 }));
    }

    @Test
    public void simple2() {
        assertEquals(4, new Solution2().candy(new int[] { 1, 2, 2 }));
    }

    @Test
    public void simple3() {
        assertEquals(7, new Solution2().candy(new int[] { 1, 3, 2, 2, 1 }));
    }

    @Test
    public void simple4() {
        assertEquals(13, new Solution2().candy(new int[] { 1, 2, 3, 3, 3, 2, 1 }));
    }
}
