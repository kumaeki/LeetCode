package kuma.p00.lc0091_Decode_Ways;

public class Solution2 {
    // Runtime: 1 ms, faster than 97.53% of Java online submissions for Decode Ways.
    // Memory Usage: 37.8 MB, less than 75.02% of Java online submissions for Decode
    // Ways.
    public int numDecodings(String s) {
        int n = s.length();
        // DP[i]表示到i位置为止的编码可能数.
        int[] dp = new int[n + 1];
        // s为空时,编码可能数为1
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            // 第一个数是0的时候结果为0
            if (i == 0) {
                if (c == '0')
                    return 0;
                else
                    dp[i + 1] = 1;
            } else {
                // 得到i的前一个数
                char pre = s.charAt(i - 1);
                if (c != '0') {
                    dp[i + 1] = dp[i];
                    if (pre == '1' || (pre == '2' && c < '7'))
                        dp[i + 1] += dp[i - 1];
                } else {
                    if (pre == '0' || pre > '2')
                        return 0;
                    else
                        dp[i + 1] = dp[i - 1];
                }
            }
        }
        return dp[n];
    }
}
