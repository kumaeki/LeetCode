package kuma.p08.lc0825_Friends_Of_Appropriate_Ages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class Solution2 {
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Friends Of
    // Appropriate Ages.
    // Memory Usage: 41.7 MB, less than 20.00% of Java online submissions for
    // Friends Of Appropriate Ages.
    public int numFriendRequests(int[] ages) {
        int[] arr = new int[121];
        for (int age : ages)
            arr[age]++;

        int res = 0;
        for (int i = 120; i > 0; i--) {
            if (arr[i] == 0)
                continue;
            int left = i / 2 + 8;
            while (left < i && arr[left] == 0)
                left++;
            while (left < i)
                res += arr[left++] * arr[i];
            if (i > 14)
                res += (arr[i] - 1) * arr[i];
        }
        return res;
    }

    @Test
    public void simple1() {
        assertEquals(2, new Solution2().numFriendRequests(new int[] { 16, 16 }));
    }

    @Test
    public void simple2() {
        assertEquals(2, new Solution2().numFriendRequests(new int[] { 16, 17, 18 }));
    }

    @Test
    public void simple3() {
        assertEquals(3, new Solution2().numFriendRequests(new int[] { 20, 30, 100, 110, 120 }));
    }

    @Test
    public void simple4() {
        assertEquals(29, new Solution2()
                .numFriendRequests(new int[] { 73, 106, 39, 6, 26, 15, 30, 100, 71, 35, 46, 112, 6, 60, 110 }));
    }

    @Test
    public void simple5() {
        assertEquals(4, new Solution2().numFriendRequests(new int[] { 8, 85, 24, 85, 69 }));
    }
}
