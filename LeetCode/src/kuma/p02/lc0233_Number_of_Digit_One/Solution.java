package kuma.p02.lc0233_Number_of_Digit_One;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of
    // Digit One.
    // Memory Usage: 36.5 MB, less than 16.67% of Java online submissions for Number
    // of Digit One.
    public int countDigitOne(int n) {
        if (n < 1)
            return 0;
        long radix = 10, k = 1;
        int count = 0, groupSize = 0;
        while (n / k > 0) {

            int num = (int) ((n % radix) / k);
            count += num * groupSize;
            if (num == 1) {
                count += n % k + 1;
            } else if (num > 1)
                count += k;

            radix *= 10;
            groupSize = (int) (k + groupSize * 10);
            k *= 10;
        }
        return count;
    }

    @Test
    public void simple1() {
        assertEquals(6, new Solution().countDigitOne(13));
    }

    @Test
    public void simple2() {
        assertEquals(194, new Solution().countDigitOne(437));
    }
}
