package kuma.p09.lc0989_Add_to_Array_Form_of_Integer;

import java.util.*;

class Solution3 {
    // Runtime: 3 ms, faster than 93.87% of Java online submissions for Add to
    // Array-Form of Integer.
    // Memory Usage: 40.8 MB, less than 100.00% of Java online submissions for Add
    // to Array-Form of Integer.
    public List<Integer> addToArrayForm(int[] A, int K) {
        int n = A.length, i = n - 1;
        List<Integer> res = new ArrayList<Integer>(n);

        while (i >= 0 || K > 0) {
            if (i >= 0)
                K += A[i--];
            res.add(K % 10);
            K /= 10;
        }
        Collections.reverse(res);
        return res;
    }
}