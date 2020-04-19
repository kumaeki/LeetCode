package kuma.p09.lc0950_Reveal_Cards_In_Increasing_Order;

import java.util.*;

public class Solution {
    // Runtime: 3 ms, faster than 42.67% of Java online submissions for Reveal Cards
    // In Increasing Order.
    // Memory Usage: 39.9 MB, less than 14.29% of Java online submissions for Reveal
    // Cards In Increasing Order.
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        LinkedList<Integer> list = new LinkedList<Integer>();
        Arrays.sort(deck);
        for (int i = n - 1; i >= 0; i--) {
            if (list.size() > 1)
                list.addFirst(list.removeLast());
            list.addFirst(deck[i]);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++)
            res[i] = list.removeFirst();

        return res;
    }
}
