package kuma.lc0003_Longest_Substring_Without_Repeating_Characters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<Character>();
        int res = 1, len = s.length();
        int left = 0, right = 0;
        while (right < len) {
            if (!set.contains(arr[right])) {
                set.add(arr[right++]);
                res = Math.max(res, set.size());
            } else
                set.remove(arr[left++]);
        }
        return res;
    }

    @Test
    public void TestSimple1() {
        int expected = 3;
        int actual = new Solution().lengthOfLongestSubstring("abcabcbb");
        assertEquals(expected, actual);
    }

    @Test
    public void TestSimple2() {
        int expected = 1;
        int actual = new Solution().lengthOfLongestSubstring("bbbbb");
        assertEquals(expected, actual);
    }

    @Test
    public void TestSimple3() {
        int expected = 3;
        int actual = new Solution().lengthOfLongestSubstring("pwwkew");
        assertEquals(expected, actual);
    }

    @Test
    public void TestSimple4() {
        int expected = 0;
        int actual = new Solution().lengthOfLongestSubstring("");
        assertEquals(expected, actual);
    }
}
