package kuma.p02.lc0274_H_Index_II;

public class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for H-Index II.
    // Memory Usage: 47.1 MB, less than 5.55% of Java online submissions for H-Index
    // II.
    public int hIndex(int[] citations) {
        int res = 0, n = citations.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (n - mid <= citations[mid]) {
                res = n - mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return res;
    }
}
