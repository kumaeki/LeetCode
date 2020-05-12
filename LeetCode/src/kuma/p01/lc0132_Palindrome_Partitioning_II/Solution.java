package kuma.p01.lc0132_Palindrome_Partitioning_II;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

public class Solution {
    // Runtime: 2 ms, faster than 99.66% of Java online submissions for Palindrome
    // Partitioning II.
    // Memory Usage: 37 MB, less than 29.17% of Java online submissions for
    // Palindrome Partitioning II.
    public int minCut(String s) {
        if (s == null || s.length() < 2)
            return 0;
        int n = s.length();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++)
            dp[i] = i;

        for (int i = 1; i < n; i++) {
            // odd len
            helper(dp, i, i, s, n);
            // even len
            helper(dp, i - 1, i, s, n);
        }
        return dp[n - 1];
    }

    private void helper(int[] dp, int left, int right, String s, int n) {
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            int pre = (left == 0 ? 0 : dp[left - 1] + 1);
            dp[right] = Math.min(dp[right], pre);
            left--;
            right++;
        }
    }

    @Test
    public void simple1() {
        assertEquals(1, new Solution().minCut("aab"));
    }
}
