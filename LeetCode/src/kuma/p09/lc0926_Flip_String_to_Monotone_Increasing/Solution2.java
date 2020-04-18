package kuma.p09.lc0926_Flip_String_to_Monotone_Increasing;

public class Solution2 {
    // Runtime: 3 ms, faster than 74.77% of Java online submissions for Flip String
    // to Monotone Increasing.
    // Memory Usage: 39.2 MB, less than 20.00% of Java online submissions for Flip
    // String to Monotone Increasing.
    public int minFlipsMonoIncr(String S) {
        int n = S.length(), res = n;
        int[] forward = new int[n + 1], backward = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            forward[i] = forward[i - 1] + (S.charAt(i - 1) - '0');
            backward[n - i] = backward[n - i + 1] + ('1' - S.charAt(n - i));
        }
        for (int i = 0; i <= n; i++)
            res = Math.min(res, forward[i] + backward[i]);
        return res;
    }
}
