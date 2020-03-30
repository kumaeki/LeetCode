package kuma.p01.lc0162_Find_Peak_Element;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution2 {
    // Runtime: 0 ms, faster than 100.00%
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[mid + 1])
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }

    @Test
    public void simple1() {
        assertEquals(2, new Solution2().findPeakElement(new int[] { 1, 2, 3, 1 }));
    }

    @Test
    public void simple2() {
        assertEquals(5, new Solution2().findPeakElement(new int[] { 1, 2, 1, 3, 5, 6, 4 }));
    }
}
