package kuma.p08.lc0888_Fair_Candy_Swap;

import java.util.*;

public class Solution2 {
    // Runtime: 8 ms, faster than 97.58% of Java online submissions for Fair Candy
    // Swap.
    // Memory Usage: 41.7 MB, less than 70.83% of Java online submissions for Fair
    // Candy Swap.
    public int[] fairCandySwap(int[] A, int[] B) {
        Set<Integer> set = new HashSet<Integer>();
        int sumA = 0, sumB = 0;
        for (int a : A)
            sumA += a;
        for (int b : B) {
            sumB += b;
            set.add(b);
        }

        int dif = (sumA - sumB) / 2;
        for (int a : A) {
            int b = a - dif;
            if (set.contains(b))
                return new int[] { a, b };
        }
        return null;
    }
}
