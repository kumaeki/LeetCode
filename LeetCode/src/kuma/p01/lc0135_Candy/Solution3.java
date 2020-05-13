package kuma.p01.lc0135_Candy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Solution3 {
    // Runtime: 2 ms, faster than 97.33% of Java online submissions for Candy.
    // Memory Usage: 40.5 MB, less than 77.27% of Java online submissions for Candy.
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;
        int n = ratings.length;
        int[] arr = new int[n];
        arr[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1])
                arr[i] = arr[i - 1] + 1;
            else
                arr[i] = 1;
        }
        int res = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                arr[i] = Math.max(arr[i + 1] + 1, arr[i]);
            res += arr[i];
        }
        return res;
    }

    @Test
    public void simple1() {
        assertEquals(5, new Solution3().candy(new int[] { 1, 0, 2 }));
    }

    @Test
    public void simple2() {
        assertEquals(4, new Solution3().candy(new int[] { 1, 2, 2 }));
    }

    @Test
    public void simple3() {
        assertEquals(7, new Solution3().candy(new int[] { 1, 3, 2, 2, 1 }));
    }

    @Test
    public void simple4() {
        assertEquals(13, new Solution3().candy(new int[] { 1, 2, 3, 3, 3, 2, 1 }));
    }
}
