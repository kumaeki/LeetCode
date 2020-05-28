package kuma.p03.lc0318_Maximum_Product_of_Word_Lengths;

import java.util.*;

public class Solution {
    // Runtime: 17 ms, faster than 44.74% of Java online submissions for Maximum
    // Product of Word Lengths.
    // Memory Usage: 39.8 MB, less than 26.32% of Java online submissions for
    // Maximum Product of Word Lengths.
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int key = 0;
            for (char c : word.toCharArray())
                key |= (1 << (c - 'a'));
            if (!map.containsKey(key) || map.get(key) < word.length())
                map.put(key, word.length());
            arr[i] = key;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int key1 = arr[i];
            for (int j = i + 1; j < n; j++) {
                if ((key1 & arr[j]) == 0)
                    res = Math.max(res, map.get(key1) * map.get(arr[j]));
            }
        }

        return res;
    }

}
