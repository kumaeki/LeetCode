package kuma.p00.lc0005_Longest_Palindromic_Substring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class Solution3 {
    // Runtime: 3 ms, faster than 99.25%
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return s;

        int lenN = 2 * s.length() + 1;
        char[] arr = new char[lenN];
        arr[0] = '#';
        for (int i = 0; i < s.length(); i++) {
            arr[i * 2 + 1] = s.charAt(i);
            arr[i * 2 + 2] = '#';
        }
        // max radius at the point i
        int[] dp = new int[lenN];
        int center = 0, radius = 0, centerRes = 0, radiusRes = 0;
        for (int i = 0; i < lenN; i++) {
            if (i < center + radius)
                dp[i] = Math.min(dp[2 * center - i], center + radius - i);
            else
                dp[i] = 0;
            int left = i - dp[i] - 1, right = i + dp[i] + 1;
            while (left >= 0 && right < lenN) {
                if (arr[left--] != arr[right++])
                    break;
                dp[i]++;
            }

            // update the longest edge
            if (center + radius < i + dp[i]) {
                center = i;
                radius = dp[i];
            }
            // update the result
            if (radiusRes < dp[i]) {
                centerRes = i;
                radiusRes = dp[i];
            }
        }
        return s.substring((centerRes - radiusRes) / 2, (centerRes + radiusRes) / 2);
    }

    @Test
    public void testSimple1() {
        String expected = "bab";
        String actual = new Solution3().longestPalindrome("babad");
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple2() {
        String expected = "bb";
        String actual = new Solution3().longestPalindrome("cbbd");
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple3() {
        String expected = "";
        String actual = new Solution3().longestPalindrome("");
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple4() {
        String expected = "ccccccccccccccccccccccccccccccc";
        String actual = new Solution3()
                .longestPalindrome("aaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbccccccccccccccccccccccccccccccc");
        assertEquals(expected, actual);
    }
}
