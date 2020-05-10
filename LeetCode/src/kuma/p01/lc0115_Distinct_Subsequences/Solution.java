package kuma.p01.lc0115_Distinct_Subsequences;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.Test;

public class Solution {
    // Time Limit Exceeded
    public int numDistinct(String s, String t) {
        Map<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c))
                map.get(c).add(i);
            else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(c, list);
            }
        }

        return helper(t, 0, map, -1);
    }

    private int helper(String t, int i, Map<Character, List<Integer>> map, int j) {
        if (i >= t.length())
            return 1;

        char c = t.charAt(i);
        if (!map.containsKey(c))
            return 0;

        int count = 0;
        List<Integer> list = map.get(c);
        for (int index : list) {
            if (index > j)
                count += helper(t, i + 1, map, index);
        }
        return count;

    }

    @Test
    public void simple1() {
        assertEquals(3, new Solution().numDistinct("rabbbit", "rabbit"));
    }
    
    @Test
    public void simple2() {
        assertEquals(3, new Solution().numDistinct("", "rabbit"));
    }
    
    @Test
    public void simple3() {
        assertEquals(3, new Solution().numDistinct("rabbbit", ""));
    }
}
