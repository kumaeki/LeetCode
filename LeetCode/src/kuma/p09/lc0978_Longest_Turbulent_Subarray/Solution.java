package kuma.p09.lc0978_Longest_Turbulent_Subarray;

class Solution {
    // Runtime: 4 ms, faster than 93.39% of Java online submissions for Longest
    // Turbulent Subarray.
    // Memory Usage: 43 MB, less than 100.00% of Java online submissions for Longest
    // Turbulent Subarray.
    public int maxTurbulenceSize(int[] A) {
        int n = A.length;
        if (n < 2)
            return n;
        int k = 0, len = 1, res = 1;
        for (int i = 0; i < n - 1; i++) {
            int dif = A[i] - A[i + 1];
            if (dif == 0) {
                k = 0;
            } else {
                if (k == 0 || dif * k > 0) {
                    if (dif > 0) {
                        k = 1;
                    } else
                        k = -1;
                    len = 2;
                    res = Math.max(res, len);
                } else if (dif * k < 0) {
                    k = -k;
                    len++;
                    res = Math.max(res, len);
                }
            }
        }
        return res;
    }
}
