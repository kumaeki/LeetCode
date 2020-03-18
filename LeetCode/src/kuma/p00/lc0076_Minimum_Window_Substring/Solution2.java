package kuma.p00.lc0076_Minimum_Window_Substring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

class Solution2 {
    public String minWindow(String s, String t) {
        if(t.isEmpty())
            return "";
        Map<Character, Integer> smap = new HashMap<Character, Integer>();
        Map<Character, Integer> tmap = new HashMap<Character, Integer>();

        for (char c : t.toCharArray())
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);

        int left = 0, right = 0;
        String res = "";
        while (right < s.length()) {
            while (right < s.length() && !helper(smap, tmap)) {
                char c = s.charAt(right++);
                smap.put(c, smap.getOrDefault(c, 0) + 1);
            }
            while (left <= right && helper(smap, tmap)) {
                String str = s.substring(left, right);
                if (res.isEmpty() || str.length() < res.length())
                    res = str;
                char c = s.charAt(left++);
                smap.put(c, smap.get(c) - 1);
            }
        }
        return res;
    }

    private boolean helper(Map<Character, Integer> smap, Map<Character, Integer> tmap) {
        if (tmap.isEmpty())
            return true;
        if (smap.isEmpty())
            return false;

        for (Map.Entry<Character, Integer> entry : tmap.entrySet())
            if (entry.getValue() > smap.getOrDefault(entry.getKey(), 0))
                return false;

        return true;
    }

    @Test
    public void simple1() {
        String expected = "BANC";
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String actual = new Solution2().minWindow(s, t);
        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        String expected = "";
        String s = "ABC";
        String t = "";
        String actual = new Solution2().minWindow(s, t);
        assertEquals(expected, actual);
    }

    @Test
    public void simple3() {
        String expected = "";
        String s = "";
        String t = "ABC";
        String actual = new Solution2().minWindow(s, t);
        assertEquals(expected, actual);
    }
}
