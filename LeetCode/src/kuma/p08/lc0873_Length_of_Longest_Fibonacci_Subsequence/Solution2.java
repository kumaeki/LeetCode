package kuma.p08.lc0873_Length_of_Longest_Fibonacci_Subsequence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;
import org.junit.Test;

public class Solution2 {
    // Runtime: 73 ms, faster than 61.03% of Java online submissions for Length of
    // Longest Fibonacci Subsequence.
    // Memory Usage: 39.4 MB, less than 85.71% of Java online submissions for Length
    // of Longest Fibonacci Subsequence.
    public int lenLongestFibSubseq(int[] A) {
        int n = A.length, res = 0;
        Map<Integer, Integer> index = new HashMap<Integer, Integer>(), count = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++)
            index.put(A[i], i);
        for (int i = 0; i < n - 2; i++)
            for (int j = i + 1; j < n - 1; j++) {
                int k = index.getOrDefault(A[i] + A[j], -1);
                if (k > 0) {
                    int m = count.getOrDefault(i << 10 | j, 0) + 1;
                    count.put(j << 10 | k, m);
                    res = Math.max(res, m);
                }
            }
        return res == 0 ? 0 : res + 2;
    }

    @Test
    public void simple1() {
        assertEquals(5, new Solution2().lenLongestFibSubseq(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
    }
}
