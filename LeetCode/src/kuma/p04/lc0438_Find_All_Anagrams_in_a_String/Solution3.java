package kuma.p04.lc0438_Find_All_Anagrams_in_a_String;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import java.util.*;

public class Solution3 {
    // Runtime: 5 ms, faster than 94.81%
    public List<Integer> findAnagrams(String s, String p) {
        int[] arrp = new int[26], arrs = new int[26];
        for (char c : p.toCharArray())
            arrp[c - 'a']++;

        int count = 0, lenp = p.length(), lens = s.length();
        List<Integer> list = new ArrayList<Integer>(lens);
        for (int i = 0; i < lens; i++) {
            char c = s.charAt(i);
            if (arrp[c - 'a'] == 0) {
                arrs[c - 'a']++;
                if (count++ > lenp - 1) {
                    char pre = s.charAt(i - lenp);
                    arrs[pre - 'a']--;
                    count--;
                }
                if (isEquals(arrs, arrp))
                    list.add(i - lenp + 1);
            } else {
                count = 0;
                arrs = new int[26];
            }
        }
        return list;
    }

    private boolean isEquals(int[] s, int[] p) {
        for (int i = 0; i < 26; i++)
            if (s[i] != p[i])
                return false;
        return true;
    }

    @Test
    public void simple1() {
        Integer[] expecteds = new Integer[] { 0, 6 };
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> list = new Solution3().findAnagrams(s, p);
        Integer[] actuals = list.toArray(new Integer[list.size()]);

        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void simple2() {
        Integer[] expecteds = new Integer[] { 0, 1, 2 };
        String s = "abab";
        String p = "ab";
        List<Integer> list = new Solution3().findAnagrams(s, p);
        Integer[] actuals = list.toArray(new Integer[list.size()]);

        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void simple3() {
        Integer[] expecteds = new Integer[] {};
        String s = "";
        String p = "a";
        List<Integer> list = new Solution3().findAnagrams(s, p);
        Integer[] actuals = list.toArray(new Integer[list.size()]);

        assertArrayEquals(expecteds, actuals);
    }
}
