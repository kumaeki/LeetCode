package kuma.p00.lc0091_Decode_Ways;

public class Solution {
    // Runtime: 1 ms, faster than 97.53% of Java online submissions for Decode Ways.
    // Memory Usage: 37.8 MB, less than 75.02% of Java online submissions for Decode
    // Ways.
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 1;
        if (s.charAt(0) == '0')
            return 0;

        int n = s.length(), pre = 1, cur = 1, res = 0;

        for (int i = 1; i < n; i++) {
            char ccur = s.charAt(i);
            char cpre = s.charAt(i - 1);
            if (ccur != '0') {
                res = cur;
                if (cpre == '1' || (cpre == '2' && ccur < '7'))
                    res += pre;
            } else {
                if (cpre == '0' || cpre > '2')
                    return 0;
                else
                    res = pre;
            }
            pre = cur;
            cur = res;
        }
        return cur;
    }
}
