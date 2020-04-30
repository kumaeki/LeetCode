package kuma.p00.lc0080_Remove_Duplicates_from_Sorted_Array_II;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Solution2 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove
    // Duplicates from Sorted Array II.
    // Memory Usage: 39.6 MB, less than 5.26% of Java online submissions for Remove
    // Duplicates from Sorted Array II.
    public int removeDuplicates(int[] nums) {
        if (nums == null)
            return 0;
        if (nums.length < 3)
            return nums.length;

        int left = 2, len = nums.length;
        for (int right = 2; right < len; right++) {
            if (nums[right] > nums[left - 2])
                nums[left++] = nums[right];
        }
        return left;
    }

    @Test
    public void simple1() {
        assertEquals(5, new Solution2().removeDuplicates(new int[] { 1, 1, 1, 2, 2, 3 }));
    }

    @Test
    public void simple2() {
        assertEquals(7, new Solution2().removeDuplicates(new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 }));
    }
}
