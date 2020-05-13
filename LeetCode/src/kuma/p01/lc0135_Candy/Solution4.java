package kuma.p01.lc0135_Candy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Solution4 {
    // Runtime: 2 ms, faster than 97.33% of Java online submissions for Candy.
    // Memory Usage: 40.1 MB, less than 100.00% of Java online submissions for
    // Candy.
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;
        int peak = 0, up = 0, down = 0, res = 1;
        for (int i = 1, n = ratings.length; i < n; i++) {
            if (ratings[i - 1] > ratings[i]) {
                up = 0;
                down++;
                res += (1 + down + (peak >= down ? -1 : 0));
            } else if (ratings[i - 1] == ratings[i]) {
                peak = up = down = 0;
                res++;
            }
            // ratings[i-1] < ratings[i]
            else {
                down = 0;
                up++;
                peak = up;
                res += (1 + up);
            }
        }
        return res;
    }

    @Test
    public void simple1() {
        assertEquals(5, new Solution4().candy(new int[] { 1, 0, 2 }));
    }

    @Test
    public void simple2() {
        assertEquals(4, new Solution4().candy(new int[] { 1, 2, 2 }));
    }

    @Test
    public void simple3() {
        assertEquals(7, new Solution4().candy(new int[] { 1, 3, 2, 2, 1 }));
    }

    @Test
    public void simple4() {
        assertEquals(13, new Solution4().candy(new int[] { 1, 2, 3, 3, 3, 2, 1 }));
    }
}
