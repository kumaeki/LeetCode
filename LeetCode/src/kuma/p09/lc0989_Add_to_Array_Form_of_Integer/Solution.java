package kuma.p09.lc0989_Add_to_Array_Form_of_Integer;

import java.util.*;

class Solution {
    // Runtime: 41 ms, faster than 25.47% of Java online submissions for Add to
    // Array-Form of Integer.
    // Memory Usage: 41 MB, less than 100.00% of Java online submissions for Add to
    // Array-Form of Integer.
    public List<Integer> addToArrayForm(int[] A, int K) {
        int n = A.length, pre = 0, a;
        List<Integer> res = new ArrayList<Integer>(n);
        for (int i = n - 1; i >= 0; i--) {
            a = A[i] + pre + K % 10;
            pre = 0;
            if (a > 9) {
                pre = 1;
                a %= 10;
            }
            res.add(0, a);
            K /= 10;
        }
        while (K != 0) {
            a = pre + K % 10;
            pre = 0;
            if (a > 9) {
                pre = 1;
                a %= 10;
            }
            res.add(0, a);
            K /= 10;
        }
        if (pre == 1)
            res.add(0, 1);
        return res;
    }
}