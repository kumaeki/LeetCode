package kuma.p01.lc0187_Repeated_DNA_Sequences;

import java.util.*;

public class Solution {
    // Runtime: 20 ms, faster than 37.64% of Java online submissions for Repeated
    // DNA Sequences.
    // Memory Usage: 48.4 MB, less than 51.61% of Java online submissions for
    // Repeated DNA Sequences.
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int n = s.length();
        for (int i = 0; i <= n - 10; i++) {
            String str = s.substring(i, i + 10);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        List<String> list = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : map.entrySet())
            if (entry.getValue() > 1)
                list.add(entry.getKey());
        return list;
    }
}
