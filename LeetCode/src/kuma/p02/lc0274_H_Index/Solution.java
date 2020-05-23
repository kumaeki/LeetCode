package kuma.p02.lc0274_H_Index;

import java.util.Arrays;

public class Solution {
    // Runtime: 1 ms, faster than 40.92% of Java online submissions for H-Index.
    // Memory Usage: 37 MB, less than 100.00% of Java online submissions for
    // H-Index.
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        Arrays.sort(citations);
        int left = 0, right = citations.length - 1;
        while (left < right) {
            int temp = citations[left];
            citations[left] = citations[right];
            citations[right] = temp;
            left++;
            right--;
        }

        left = 0;
        right = citations.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (citations[mid] >= mid + 1)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return right + 1;
    }
}
