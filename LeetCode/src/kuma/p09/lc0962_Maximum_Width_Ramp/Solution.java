package kuma.p09.lc0962_Maximum_Width_Ramp;

class Solution {
    // Time Limit Exceeded
    public int maxWidthRamp(int[] A) {
        int n = A.length, res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (A[j] >= A[i]) {
                    res = Math.max(res, j - i);
                    break;
                }
            }
            if (n - i < res)
                break;
        }
        return res;
    }
}
