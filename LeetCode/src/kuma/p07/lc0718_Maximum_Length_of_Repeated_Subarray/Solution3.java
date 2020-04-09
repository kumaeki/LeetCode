package kuma.p07.lc0718_Maximum_Length_of_Repeated_Subarray;

public class Solution3 {
    // Runtime: 40 ms, faster than 75.79% of Java online submissions for Maximum
    // Length of Repeated Subarray.
    // Memory Usage: 49 MB, less than 80.00% of Java online submissions for Maximum
    // Length of Repeated Subarr
    public int findLength(int[] A, int[] B) {
        int lena = A.length, lenb = B.length, res = 0;
        int[][] dp = new int[lena + 1][lenb + 1];
        for (int i = lena - 1; i >= 0; i--)
            for (int j = lenb - 1; j >= 0; j--)
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }

        return res;
    }
}
