package kuma.lc0076_Minimum_Window_Substring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty())
            return "";
        Map<Character, Integer> smap = new HashMap<Character, Integer>();
        Map<Character, Integer> tmap = new HashMap<Character, Integer>();

        for (char c : t.toCharArray())
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);

        int required = tmap.size(), cur = 0;
        int left = 0, right = 0;
        int[] res = new int[] { -1, 0, 0 };

        while (right < s.length()) {
            char c = s.charAt(right);
            smap.put(c, smap.getOrDefault(c, 0) + 1);
            if (tmap.containsKey(c) && smap.get(c).equals(tmap.get(c)))
                cur++;

            while (left <= right && cur == required) {
                if (res[0] == -1 || right - left + 1 < res[0]) {
                    res[0] = right - left + 1;
                    res[1] = left;
                    res[2] = right;
                }

                char ch = s.charAt(left);
                smap.put(ch, smap.get(ch) - 1);
                if (tmap.containsKey(ch) && smap.get(ch).compareTo(tmap.get(ch)) < 0)
                    cur--;
                left++;
            }
            right++;
        }
        return res[0] == -1 ? "" : s.substring(res[1], res[2] + 1);
    }

    @Test
    public void simple1() {
        String expected = "BANC";
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String actual = new Solution().minWindow(s, t);
        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        String expected = "abbbbbcdd";
        String s = "aaaaaaaaaaaabbbbbcdd";
        String t = "abcdd";
        String actual = new Solution().minWindow(s, t);
        assertEquals(expected, actual);
    }

    @Test
    public void simple3() {
        String expected = "";
        String s = "a";
        String t = "aa";
        String actual = new Solution().minWindow(s, t);
        assertEquals(expected, actual);
    }
}
