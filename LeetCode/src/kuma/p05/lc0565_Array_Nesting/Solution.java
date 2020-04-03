package kuma.p05.lc0565_Array_Nesting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution {
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Array
    // Nesting.
    // Memory Usage: 40.6 MB, less than 91.67% of Java online submissions for Array
    // Nesting.

    public int arrayNesting(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0)
                max = Math.max(max, helper(nums, i));
        }
        return max;
    }

    private int helper(int[] nums, int index) {
        int count = 0, next = index, val;
        do {
            count++;
            val = nums[next];
            if (val < 0)
                return 0;
            nums[next] = -val;
            next = val;
        } while (next != index);
        return count;
    }

    @Test
    public void simple1() {
        assertEquals(4, new Solution().arrayNesting(new int[] { 5, 4, 0, 3, 1, 6, 2 }));
    }

}
