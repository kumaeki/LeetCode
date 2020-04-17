package kuma.p09.lc0914_X_of_a_Kind_in_a_Deck_of_Cards;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution {
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for X of a Kind
    // in a Deck of Cards.
    // Memory Usage: 40.5 MB, less than 14.29% of Java online submissions for X of a
    // Kind in a Deck of Cards.
    public boolean hasGroupsSizeX(int[] deck) {
        int max = deck[0];
        for (int d : deck)
            if (d > max)
                max = d;

        int[] arr = new int[max + 1];
        for (int d : deck)
            arr[d]++;

        int count = 0;
        for (int a : arr)
            if (a != 0) {
                if (count == 0)
                    count = a;
                else {
                    count = getGCD(count, a);
                    if (count == 1)
                        return false;
                }
            }
        return count != 1;
    }

    private int getGCD(int i, int j) {
        while (i % j != 0) {
            int k = i % j;
            i = j;
            j = k;
        }
        return j;
    }

    @Test
    public void simple1() {
        assertEquals(true, new Solution().hasGroupsSizeX(new int[] { 1, 1, 2, 2, 2, 2 }));
    }
}
