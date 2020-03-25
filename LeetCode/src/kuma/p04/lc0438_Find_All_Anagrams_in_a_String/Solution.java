package kuma.p04.lc0438_Find_All_Anagrams_in_a_String;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import java.util.*;

public class Solution {
    // Runtime: 6 ms, faster than 85.79%
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        int[] arrp = new int[26];
        for (char c : p.toCharArray())
            arrp[c - 'a']++;

        int count = p.length(), left = 0, right = 0;
        while (right < s.length()) {

            char c = s.charAt(right++);
            if (arrp[c - 'a']-- > 0)
                count--;

            if (count == 0)
                list.add(left);

            if (right - left == p.length() && arrp[s.charAt(left++) - 'a']++ >= 0)
                count++;
        }
        return list;
    }

    @Test
    public void simple1() {
        Integer[] expecteds = new Integer[] { 0, 6 };
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> list = new Solution().findAnagrams(s, p);
        Integer[] actuals = list.toArray(new Integer[list.size()]);

        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void simple2() {
        Integer[] expecteds = new Integer[] { 0, 1, 2 };
        String s = "abab";
        String p = "ab";
        List<Integer> list = new Solution().findAnagrams(s, p);
        Integer[] actuals = list.toArray(new Integer[list.size()]);

        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void simple3() {
        Integer[] expecteds = new Integer[] {};
        String s = "";
        String p = "a";
        List<Integer> list = new Solution().findAnagrams(s, p);
        Integer[] actuals = list.toArray(new Integer[list.size()]);

        assertArrayEquals(expecteds, actuals);
    }
    
    @Test
    public void simple4() {
        Integer[] expecteds = new Integer[] { 0, 6 };
        String s = "ecbaebabacd";
        String p = "abc";
        List<Integer> list = new Solution().findAnagrams(s, p);
        Integer[] actuals = list.toArray(new Integer[list.size()]);

        assertArrayEquals(expecteds, actuals);
    }
}
