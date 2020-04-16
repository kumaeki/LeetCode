package kuma.p08.lc0888_Fair_Candy_Swap;

import java.util.*;

public class Solution {
    // Runtime: 10 ms, faster than 65.51% of Java online submissions for Fair Candy
    // Swap.
    // Memory Usage: 40.9 MB, less than 95.83% of Java online submissions for Fair
    // Candy Swap.
    public int[] fairCandySwap(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int sumA = 0, sumB = 0;
        for (int a : A)
            sumA += a;
        for (int b : B)
            sumB += b;
        int dif = sumA - sumB;
        int left = B.length - 1, right = A.length - 1;
        while (left >= 0 && right >= 0) {
            int d = (A[right] - B[left]) * 2;
            if (d > dif)
                right--;
            else if (d < dif)
                left--;
            else
                return new int[] { A[right], B[left] };
        }
        return null;
    }
}
