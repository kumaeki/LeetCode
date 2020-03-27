package kuma.p06.lc0647_Palindromic_Substrings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution3 {
    // Runtime: 1 ms, faster than 99.98% 
    public int countSubstrings(String s) {
        int len = 2 * s.length() + 1;
        char[] arr = new char[len];
        arr[0] = '#';
        for (int i = 0; i < s.length(); i++) {
            arr[2 * i + 1] = s.charAt(i);
            arr[2 * i + 2] = '#';
        }

        int center = 0, radius = 0, left, right;
        int[] dp = new int[len];
        for (int i = 1; i < len - 1; i++) {
            if (i < center + radius)
                dp[i] = Math.min(dp[2 * center - i], center + radius - i);
            else
                dp[i] = 0;
            left = i - dp[i] - 1;
            right = i + dp[i] + 1;
            while (left >= 0 && right < len) {
                if (arr[left--] != arr[right++])
                    break;
                dp[i]++;
            }
            if (i + dp[i] > center + radius) {
                center = i;
                radius = dp[i];
            }
        }

        int res = 0;
        for (int i = 1; i < len - 1; i++)
            res += (dp[i] + 1) / 2;
        return res;
    }

    @Test
    public void empty1() {
        assertEquals(0, new Solution3().countSubstrings(""));
    }

    @Test
    public void simple1() {
        assertEquals(3, new Solution3().countSubstrings("abc"));
    }

    @Test
    public void simple2() {
        assertEquals(6, new Solution3().countSubstrings("aaa"));
    }

    @Test
    public void simple3() {
        assertEquals(4, new Solution3().countSubstrings("aba"));
    }
}
