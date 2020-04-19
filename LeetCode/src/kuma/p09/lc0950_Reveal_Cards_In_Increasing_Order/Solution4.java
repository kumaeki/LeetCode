package kuma.p09.lc0950_Reveal_Cards_In_Increasing_Order;

import java.util.*;

public class Solution4 {
    // Runtime: 2 ms, faster than 96.69% of Java online submissions for Reveal Cards
    // In Increasing Order.
    // Memory Usage: 39.5 MB, less than 14.29% of Java online submissions for Reveal
    // Cards In Increasing Order.
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i++)
            list.addLast(i);
        Arrays.sort(deck);
        int[] res = new int[n];
        for (int card : deck) {
            res[list.removeFirst()] = card;
            if (!list.isEmpty())
                list.addLast(list.removeFirst());
        }
        return res;
    }
}
