package kuma.p07.lc0792_Number_of_Matching_Subsequences;

import java.util.*;

public class Solution {
    // Runtime: 51 ms, faster than 80.75% of Java online submissions for Number of
    // Matching Subsequences.
    // Memory Usage: 42.1 MB, less than 12.50% of Java online submissions for Number
    // of Matching Subsequences.
    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, LinkedList<String>> map = new HashMap<Character, LinkedList<String>>();
        for (char c = 'a'; c <= 'z'; c++)
            map.putIfAbsent(c, new LinkedList<String>());

        for (String w : words)
            map.get(w.charAt(0)).addLast(w);

        int res = 0;
        for (char c : S.toCharArray()) {
            LinkedList<String> list = map.get(c);
            for (int i = 0, len = list.size(); i < len; i++) {
                String str = list.removeFirst();
                if (str.length() == 1)
                    res++;
                else
                    map.get(str.charAt(1)).addLast(str.substring(1));
            }
        }
        return res;
    }
}
