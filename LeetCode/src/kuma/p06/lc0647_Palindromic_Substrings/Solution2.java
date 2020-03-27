package kuma.p06.lc0647_Palindromic_Substrings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution2 {
    // Runtime: 1 ms, faster than 99.98%
    public int countSubstrings(String s) {
        int res = 0, len = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < len; i++) {
            res += 1;
            // odd length
            int left = i - 1, right = i + 1;
            while (left >= 0 && right < len) {
                if (arr[left--] != arr[right++])
                    break;
                res++;
            }
            // even length
            left = i;
            right = i + 1;
            while (left >= 0 && right < len) {
                if (arr[left--] != arr[right++])
                    break;
                res++;
            }
        }
        return res;
    }

    @Test
    public void empty1() {
        assertEquals(0, new Solution2().countSubstrings(""));
    }

    @Test
    public void simple1() {
        assertEquals(3, new Solution2().countSubstrings("abc"));
    }

    @Test
    public void simple2() {
        assertEquals(6, new Solution2().countSubstrings("aaa"));
    }
}
