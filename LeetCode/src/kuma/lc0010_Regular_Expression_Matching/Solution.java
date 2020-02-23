package kuma.lc0010_Regular_Expression_Matching;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution {

    public boolean isMatch3(String s, String p) {
        int lens = s.length();
        int lenp = p.length();
        boolean[][] arr = new boolean[lens + 1][lenp + 1];
        arr[lens][lenp] = true;
        for (int i = lens; i >= 0; i--)
            for (int j = lenp - 1; j >= 0; j--) {
                boolean isMatchLeft = i < lens && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if (j + 1 < lenp && p.charAt(j + 1) == '*')
                    arr[i][j] = arr[i][j + 2] || (isMatchLeft && arr[i + 1][j]);
                else
                    arr[i][j] = isMatchLeft && arr[i + 1][j + 1];
            }
        return arr[0][0];

    }

    public boolean isMatch(String s, String p) {

        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int j = 0; j < n; j++) {
            if (p.charAt(j) == '*')
                dp[0][j + 1] = dp[0][j - 1];
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                boolean isCharMatch = s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
                boolean isPreCharMatch = j > 0 && (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                if (j > 0 && p.charAt(j) == '*')
                    dp[i + 1][j + 1] = dp[i + 1][j - 1] || (isPreCharMatch && dp[i][j + 1]);
                else
                    dp[i + 1][j + 1] = isCharMatch && dp[i][j];
            }
        return dp[m][n];
    }

    public boolean isMatch4(String s, String p) {

        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int j = 0; j < n; j++) {
            if (p.charAt(j) == '*')
                dp[0][j + 1] = dp[0][j - 1];
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {

                if (isCharMatch(s.charAt(i), p.charAt(j)))
                    dp[i + 1][j + 1] = dp[i][j];

                if (p.charAt(j) == '*') {
                    if (isCharMatch(s.charAt(i), p.charAt(j - 1))) {
                        dp[i + 1][j + 1] = dp[i + 1][j + 1] || dp[i + 1][j - 1] || dp[i][j - 1] || dp[i][j + 1];
                    } else {
                        dp[i + 1][j + 1] = dp[i + 1][j + 1] || dp[i + 1][j - 1];
                    }
                }
            }
        return dp[m][n];
    }

    private boolean isCharMatch(char c1, char c2) {
        return c1 == c2 || c2 == '.';
    }

    public boolean isMatch2(String s, String p) {
        if (s.isEmpty()) {
            if (p.isEmpty())
                return true;
            else if (p.length() == 1)
                return false;
            else if (p.charAt(1) == '*')
                return isMatch(s, p.substring(2));
            else
                return false;
        } else {
            if (p.isEmpty())
                return false;
            else if (p.length() == 1)
                return s.length() == 1 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0));
            else if (p.charAt(1) == '*')
                return isMatch(s, p.substring(2))
                        || ((p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)) && isMatch(s.substring(1), p));
            else
                return (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)) && isMatch(s.substring(1), p.substring(1));
        }
    }

    @Test
    public void testSimple1() {
        assertEquals(false, new Solution().isMatch("aa", "a"));

    }

    @Test
    public void testSimple2() {
        assertEquals(true, new Solution().isMatch("aa", "a*"));

    }

    @Test
    public void testSimple3() {
        assertEquals(true, new Solution().isMatch("ab", ".*"));

    }

    @Test
    public void testSimple4() {
        assertEquals(true, new Solution().isMatch("aab", "c*a*b"));

    }

    @Test
    public void testSimple5() {
        assertEquals(false, new Solution().isMatch("mississippi", "mis*is*p*."));

    }
}
