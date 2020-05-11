package kuma.p01.lc0115_Distinct_Subsequences;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution3 {
    // Runtime: 3 ms, faster than 97.74% of Java online submissions for Distinct Subsequences.
    // Memory Usage: 39.3 MB, less than 7.69% of Java online submissions for Distinct Subsequences.
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[] cur, pre = new int[n + 1];
        pre[n] = 1;

        for (int i = m - 1; i >= 0; i--) {
            char c = s.charAt(i);
            cur = new int[n + 1];
            for (int j = n - 1; j >= 0; j--) {
                if (c == t.charAt(j))
                    cur[j] = pre[j] + pre[j + 1];
                else
                    cur[j] = pre[j];
            }
            pre = cur;
            pre[n] = 1;

        }
        return pre[0];
    }

    @Test
    public void simple1() {
        assertEquals(3, new Solution3().numDistinct("rabbbit", "rabbit"));
    }

    @Test
    public void simple2() {
        assertEquals(0, new Solution3().numDistinct("", "rabbit"));
    }

    @Test
    public void simple3() {
        assertEquals(1, new Solution3().numDistinct("rabbbit", ""));
    }

    @Test
    public void simple4() {
        assertEquals(5, new Solution3().numDistinct("babgbag", "bag"));
    }
}
