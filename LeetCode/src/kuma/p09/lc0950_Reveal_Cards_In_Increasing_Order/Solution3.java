package kuma.p09.lc0950_Reveal_Cards_In_Increasing_Order;

import static org.junit.Assert.assertArrayEquals;
import java.util.*;
import org.junit.jupiter.api.Test;

public class Solution3 {
    // Runtime: 2 ms, faster than 96.69% of Java online submissions for Reveal Cards
    // In Increasing Order.
    // Memory Usage: 39.5 MB, less than 14.29% of Java online submissions for Reveal
    // Cards In Increasing Order.
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length, i = 1, j = 0, dif = 1;
        int[] res = new int[n];
        Arrays.sort(deck);
        res[0] = deck[0];
        while (i < n) {
            if (j >= n)
                j = 0;
            else {
                if (res[j] == 0) {
                    if (dif == 0) {
                        res[j] = deck[i++];
                        dif = 1;
                    } else {
                        dif = 0;
                    }
                }
            }
            j++;
        }
        return res;
    }

    @Test
    public void simple1() {
        assertArrayEquals(new int[] { 2, 13, 3, 11, 5, 17, 7 },
                new Solution3().deckRevealedIncreasing(new int[] { 17, 13, 11, 2, 3, 5, 7 }));
    }
}
