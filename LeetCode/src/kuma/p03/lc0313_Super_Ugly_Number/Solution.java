package kuma.p03.lc0313_Super_Ugly_Number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Solution {
    // Runtime: 16 ms, faster than 68.85% of Java online submissions for Super Ugly
    // Number.
    // Memory Usage: 37.3 MB, less than 50.00% of Java online submissions for Super
    // Ugly Number.
    public int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int[] ugly = new int[n], indexs = new int[len];
        ;
        ugly[0] = 1;

        for (int i = 1; i < n; i++) {
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++)
                ugly[i] = Math.min(ugly[i], primes[j] * ugly[indexs[j]]);
            for (int j = 0; j < len; j++)
                if (primes[j] * ugly[indexs[j]] <= ugly[i])
                    indexs[j]++;
        }
        return ugly[n - 1];
    }

    @Test
    public void simple1() {
        assertEquals(32, new Solution().nthSuperUglyNumber(12, new int[] { 2, 7, 13, 19 }));
    }
}
