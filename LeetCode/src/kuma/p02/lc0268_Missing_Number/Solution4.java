package kuma.p02.lc0268_Missing_Number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution4 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Missing
    // Number.
    // Memory Usage: 39.9 MB, less than 100.00% of Java online submissions for
    // Missing Number.
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expected = n * (n + 1) / 2, actual = 0;
        for (int i = 0; i < n; i++)
            actual += nums[i];
        return expected - actual;
    }

    @Test
    public void simple1() {
        assertEquals(0, new Solution4().missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 8, 1 }));
    }

    @Test
    public void simple2() {
        assertEquals(8, new Solution4().missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));
    }

    @Test
    public void simple3() {
        assertEquals(2, new Solution4().missingNumber(new int[] { 3, 0, 1 }));
    }

    @Test
    public void simple4() {
        assertEquals(0, new Solution4().missingNumber(new int[] { 1 }));
    }

    @Test
    public void simple5() {
        assertEquals(1, new Solution4().missingNumber(new int[] { 0 }));
    }
}
