package kuma.p09.lc0950_Reveal_Cards_In_Increasing_Order;

import java.util.*;

public class Solution2 {
    // Runtime: 5 ms, faster than 14.66% of Java online submissions for Reveal Cards
    // In Increasing Order.
    // Memory Usage: 39.3 MB, less than 14.29% of Java online submissions for Reveal
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
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
