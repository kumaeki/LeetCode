package kuma.p09.lc0969_Pancake_Sorting;

import static org.junit.Assert.assertArrayEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

public class Solution2 {
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Pancake
    // Sorting.
    // Memory Usage: 39.1 MB, less than 5.26% of Java online submissions for Pancake
    // Sorting.
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> ans = new ArrayList();
        int N = A.length;

        Integer[] B = new Integer[N];
        for (int i = 0; i < N; ++i)
            B[i] = i + 1;
        Arrays.sort(B, (i, j) -> A[j - 1] - A[i - 1]);

        for (int i : B) {
            for (int f : ans)
                if (i <= f)
                    i = f + 1 - i;
            ans.add(i);
            ans.add(N--);
        }

        return ans;
    }

    @Test
    public void simple1() {
        assertArrayEquals(new Integer[] { 4, 2, 4, 3 },
                new Solution2().pancakeSort(new int[] { 3, 2, 4, 1 }).toArray(new Integer[4]));
    }
}
