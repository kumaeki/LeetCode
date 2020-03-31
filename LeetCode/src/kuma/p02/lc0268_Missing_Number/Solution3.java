package kuma.p02.lc0268_Missing_Number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution3 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Missing
    // Number.
    // Memory Usage: 40.6 MB, less than 96.84% of Java online submissions for
    // Missing Number.
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++)
            res ^= (i ^ nums[i]);
        return res;
    }

    @Test
    public void simple1() {
        assertEquals(0, new Solution3().missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 8, 1 }));
    }

    @Test
    public void simple2() {
        assertEquals(8, new Solution3().missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));
    }

    @Test
    public void simple3() {
        assertEquals(2, new Solution3().missingNumber(new int[] { 3, 0, 1 }));
    }

    @Test
    public void simple4() {
        assertEquals(0, new Solution3().missingNumber(new int[] { 1 }));
    }

    @Test
    public void simple5() {
        assertEquals(1, new Solution3().missingNumber(new int[] { 0 }));
    }
}
