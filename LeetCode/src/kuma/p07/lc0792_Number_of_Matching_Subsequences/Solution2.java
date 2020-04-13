package kuma.p07.lc0792_Number_of_Matching_Subsequences;

import java.util.*;

public class Solution2 {
    // Runtime: 25 ms, faster than 100.00% of Java online submissions for Number of
    // Matching Subsequences.
    // Memory Usage: 40.2 MB, less than 62.50% of Java online submissions for Number
    // of Matching Subsequences.
    public int numMatchingSubseq(String S, String[] words) {

        LinkedList<Item>[] arr = new LinkedList[26];
        for (int i = 0; i < 26; i++)
            arr[i] = new LinkedList<Item>();

        for (String w : words)
            arr[w.charAt(0) - 'a'].addLast(new Item(w, 0));

        int res = 0;
        for (char c : S.toCharArray()) {
            LinkedList<Item> list = arr[c - 'a'];
            for (int i = 0, len = list.size(); i < len; i++) {
                Item item = list.removeFirst();
                if (item.index == item.word.length() - 1)
                    res++;
                else {
                    item.index++;
                    arr[item.word.charAt(item.index) - 'a'].addLast(item);
                }

            }
        }
        return res;
    }

    class Item {
        String word;
        int index;

        public Item(String word, int index) {
            this.word = word;
            this.index = index;
        }
    }
}
