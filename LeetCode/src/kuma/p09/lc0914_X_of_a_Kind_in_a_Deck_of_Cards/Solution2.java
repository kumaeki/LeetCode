package kuma.p09.lc0914_X_of_a_Kind_in_a_Deck_of_Cards;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.Test;

public class Solution2 {
    // Runtime: 7 ms, faster than 68.02% of Java online submissions for X of a Kind
    // in a Deck of Cards.
    // Memory Usage: 39.6 MB, less than 57.14% of Java online submissions for X of a
    // Kind in a Deck of Cards.
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int d : deck)
            map.put(d, map.getOrDefault(d, 0) + 1);

        int count = 0;
        for (int v : map.values())
            if (v != 0) {
                if (count == 0)
                    count = v;
                else {
                    count = getGCD(count, v);
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
        assertEquals(true, new Solution2().hasGroupsSizeX(new int[] { 1, 1, 2, 2, 2, 2 }));
    }
}
