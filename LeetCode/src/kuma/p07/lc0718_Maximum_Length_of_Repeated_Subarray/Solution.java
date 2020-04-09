package kuma.p07.lc0718_Maximum_Length_of_Repeated_Subarray;

import java.util.*;

public class Solution {
    // Runtime: 1934 ms, faster than 6.98% of Java online submissions for Maximum
    // Length of Repeated Subarray.
    // Memory Usage: 39.5 MB, less than 95.00% of Java online submissions for
    // Maximum Length of Repeated Subarray.
    public int findLength(int[] A, int[] B) {
        List<Integer>[] listB = new List[1001];
        for (int i = 0; i < B.length; i++) {
            int b = B[i];
            List<Integer> list = listB[b];
            if (list == null) {
                list = new ArrayList<Integer>();
                listB[b] = list;
            }
            list.add(i);
        }

        int res = 0, lenA = A.length, lenB = B.length;
        for (int i = 0; i < lenA; i++) {
            int a = A[i];
            if (listB[a] == null)
                continue;
            for (int j : listB[a]) {
                int nexta = i, nextb = j, len = 0;
                while (nexta < lenA && nextb < lenB && A[nexta] == B[nextb]) {
                    nexta++;
                    nextb++;
                    len++;
                }
                res = Math.max(res, len);
            }
        }
        return res;
    }
}
