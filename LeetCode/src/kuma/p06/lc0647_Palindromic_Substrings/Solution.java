package kuma.p06.lc0647_Palindromic_Substrings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution {
    // Runtime: 3 ms, faster than 71.68%
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = 1;
            // odd length
            for (int j = 1; i - j >= 0 && i + j < s.length(); j++) {
                if (s.charAt(i - j) == s.charAt(i + j))
                    temp++;
                else
                    break;
            }
            // even length
            for (int j = 0; i - j >= 0 && i + 1 + j < s.length(); j++) {
                if (s.charAt(i - j) == s.charAt(i + 1 + j))
                    temp++;
                else
                    break;
            }
            res += temp;
        }
        return res;
    }

    @Test
    public void empty1() {
        assertEquals(0, new Solution().countSubstrings(""));
    }

    @Test
    public void simple1() {
        assertEquals(3, new Solution().countSubstrings("abc"));
    }

    @Test
    public void simple2() {
        assertEquals(6, new Solution().countSubstrings("aaa"));
    }
}
