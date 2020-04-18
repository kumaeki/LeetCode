package kuma.p09.lc0918_Maximum_Sum_Circular_Subarray;

import java.util.*;

public class Solution4 {
    // Runtime: 3 ms, faster than 88.82% of Java online submissions for Maximum Sum
    // Circular Subarray.
    // Memory Usage: 46.1 MB, less than 10.00% of Java online submissions for
    // Maximum Sum Circular Subarray.
    public int maxSubarraySumCircular(int[] A) {
        int l = A.length, n = l * 2;
        int[] B = new int[n];
        B[0] = A[0];
        for (int i = 1; i < n; i++)
            B[i] = B[i - 1] + A[i % l];

        int res = A[0];
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(0);
        for (int j = 1; j < n; j++) {
            if (j - list.getFirst() > l)
                list.removeFirst();
            res = Math.max(res, B[j] - B[list.getFirst()]);
            while (!list.isEmpty() && B[j] <= B[list.getLast()])
                list.removeLast();
            list.addLast(j);
        }
        return res;
    }
}
