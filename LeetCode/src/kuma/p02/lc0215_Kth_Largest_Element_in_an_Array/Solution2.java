package kuma.p02.lc0215_Kth_Largest_Element_in_an_Array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import java.util.*;

public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len - k];
    }

    @Test
    public void simple1() {
        int expected = 4;
        int[] nums = new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int k = 4;
        int actual = new Solution2().findKthLargest(nums, k);
        assertEquals(expected, actual);
    }

}
