package kuma.p04.lc0438_Find_All_Anagrams_in_a_String;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import java.util.*;

public class Solution4 {
    // Runtime: 42 ms, faster than 25.88% 
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> mapp = new HashMap<Character, Integer>();
        Map<Character, Integer> maps = new HashMap<Character, Integer>();
        for (char c : p.toCharArray())
            mapp.put(c, mapp.getOrDefault(c, 0) + 1);

        int count = 0, lenp = p.length(), lens = s.length();
        List<Integer> list = new ArrayList<Integer>(lens);
        for (int i = 0; i < lens; i++) {
            char c = s.charAt(i);
            maps.put(c, maps.getOrDefault(c, 0) + 1);
            if (count++ > lenp - 1) {
                char pre = s.charAt(i - lenp);
                maps.put(pre, maps.get(pre) - 1);
                count--;
            }
            if (isEquals(maps, mapp))
                list.add(i - lenp + 1);
        }

        return list;
    }

    private boolean isEquals(Map<Character, Integer> s, Map<Character, Integer> p) {
        for (Map.Entry<Character, Integer> entry : p.entrySet())
            if (!entry.getValue().equals(s.get(entry.getKey())))
                return false;
        return true;
    }

    @Test
    public void simple1() {
        Integer[] expecteds = new Integer[] { 0, 6 };
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> list = new Solution4().findAnagrams(s, p);
        Integer[] actuals = list.toArray(new Integer[list.size()]);

        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void simple2() {
        Integer[] expecteds = new Integer[] { 0, 1, 2 };
        String s = "abab";
        String p = "ab";
        List<Integer> list = new Solution4().findAnagrams(s, p);
        Integer[] actuals = list.toArray(new Integer[list.size()]);

        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void simple3() {
        Integer[] expecteds = new Integer[] {};
        String s = "";
        String p = "a";
        List<Integer> list = new Solution4().findAnagrams(s, p);
        Integer[] actuals = list.toArray(new Integer[list.size()]);

        assertArrayEquals(expecteds, actuals);
    }
}
