package kuma.lc0005_Longest_Palindromic_Substring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return s;

        char[] charArr = s.toCharArray();
        int len = s.length();
        String candidate = s.substring(0, 1);
        for (int i = 0; i < len; i++)
            for (int j = i; j < len; j++) {
                if (isPalindrome(charArr, i, j) && j - i + 1 > candidate.length())
                    candidate = s.substring(i, j + 1);
            }
        return candidate;
    }

    public boolean isPalindrome(char[] arr, int left, int right) {
        while (left <= right && arr[left] == arr[right]) {
            left++;
            right--;
        }
        if (left >= right)
            return true;
        else
            return false;
    }


    @Test
    public void testSimple1() {
        String expected = "bab";
        String actual = new Solution().longestPalindrome("babad");
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple2() {
        String expected = "bb";
        String actual = new Solution().longestPalindrome("cbbd");
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple3() {
        String expected = "";
        String actual = new Solution().longestPalindrome("");
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSimple4() {
        String expected = "ccccccccccccccccccccccccccccccc";
        String actual = new Solution().longestPalindrome("aaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbccccccccccccccccccccccccccccccc");
        assertEquals(expected, actual);
    }
}
