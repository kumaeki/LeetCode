package kuma.p03.lc0313_Super_Ugly_Number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

public class Solution3 {
    // Runtime: 12 ms, faster than 92.23% of Java online submissions for Super Ugly
    // Number.
    // Memory Usage: 37.3 MB, less than 50.00% of Java online submissions for Super
    // Ugly Number.
    public int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        // int[0] : prime factor
        // int[1] : index
        // int[2] : val
        int[] ugly = new int[n];
        ugly[0] = 1;
        PriorityQueue<int[]> que = new PriorityQueue<int[]>((x, y) -> (x[2] - y[2]));
        for (int i = 0; i < len; i++)
            que.add(new int[] { primes[i], 1, primes[i] });

        for (int i = 1; i < n; i++) {
            ugly[i] = que.peek()[2];
            while (ugly[i] == que.peek()[2]) {
                int[] next = que.poll();
                que.add(new int[] { next[0], next[1] + 1, next[0] * ugly[next[1]] });
            }
        }
        return ugly[n - 1];
    }

    @Test
    public void simple1() {
        assertEquals(32, new Solution3().nthSuperUglyNumber(12, new int[] { 2, 7, 13, 19 }));
    }
}
