package kuma.p02.lc0214_Shortest_Palindrome;

public class Solution3 {
    // Runtime: 12 ms, faster than 48.79% of Java online submissions for Shortest
    // Palindrome.
    // Memory Usage: 40.4 MB, less than 7.14% of Java online submissions for
    // Shortest Palindrome.
    public String shortestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;

        StringBuilder reverse = new StringBuilder(s).reverse();
        StringBuilder sb = new StringBuilder(s).append("#").append(reverse);
        int n = sb.length();
        int[] kmt = new int[n];
        for (int i = 1; i < n; i++) {
            int t = kmt[i - 1];
            while (t > 0 && sb.charAt(t) != sb.charAt(i))
                t = kmt[t - 1];
            if (sb.charAt(t) == sb.charAt(i))
                t++;
            kmt[i] = t;
        }
        return reverse.substring(0, s.length() - kmt[n - 1]) + s;
    }
}
