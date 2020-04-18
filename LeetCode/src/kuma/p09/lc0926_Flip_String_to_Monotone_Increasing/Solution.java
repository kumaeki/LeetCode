package kuma.p09.lc0926_Flip_String_to_Monotone_Increasing;

public class Solution {
    // Runtime: 2 ms, faster than 99.77% of Java online submissions for Flip String
    // to Monotone Increasing.
    // Memory Usage: 39.2 MB, less than 20.00% of Java online submissions for Flip
    // String to Monotone Increasing.
    public int minFlipsMonoIncr(String S) {
        int count0 = 0, count1 = 0, n = S.length();
        for (int i = 0; i < n; i++)
            count0 += ('1' - S.charAt(i));

        int res = count0;
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == '1')
                count1++;
            else
                count0--;
            res = Math.min(res, count0 + count1);
        }
        return res;
    }
}
