package kuma.p02.lc0209_Minimum_Size_Subarray_Sum;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution {
    // Runtime: 1 ms, faster than 99.89%
    // Memory Usage: 39.9 MB, less than 5.71%
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0, len = nums.length;
        int res = Integer.MAX_VALUE, sum = 0;
        while (right < len) {
            sum += nums[right];
            while (sum >= s) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left++];
            }
            right++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    @Test
    public void simple1() {
        assertEquals(2, new Solution().minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
    }

    @Test
    public void simple2() {
        assertEquals(3, new Solution().minSubArrayLen(11, new int[] { 1, 2, 3, 4, 5 }));
    }
}
