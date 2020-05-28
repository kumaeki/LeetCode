package kuma.p03.lc0313_Super_Ugly_Number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class Solution2 {
    // Runtime: 12 ms, faster than 92.23% of Java online submissions for Super Ugly
    // Number.
    // Memory Usage: 37.3 MB, less than 50.00% of Java online submissions for Super
    // Ugly Number.
    public int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int[] ugly = new int[n], indexs = new int[len], vals = new int[len];
        Arrays.fill(vals, 1);
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                if (vals[j] == ugly[i - 1])
                    vals[j] = primes[j] * ugly[indexs[j]++];
                ugly[i] = Math.min(ugly[i], vals[j]);
            }
        }
        return ugly[n - 1];
    }

    @Test
    public void simple1() {
        assertEquals(32, new Solution2().nthSuperUglyNumber(12, new int[] { 2, 7, 13, 19 }));
    }
}
