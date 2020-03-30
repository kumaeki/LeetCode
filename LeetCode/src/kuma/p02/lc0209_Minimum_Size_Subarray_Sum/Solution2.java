package kuma.p02.lc0209_Minimum_Size_Subarray_Sum;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution2 {
    // Runtime: 5 ms, faster than 14.91%
    // Memory Usage: 39.6 MB, less than 5.71% 
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        int[] sumArr = new int[len + 1];
        for (int i = 1; i <= len; i++)
            sumArr[i] = sumArr[i - 1] + nums[i - 1];

        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= len; i++) {
            int start = i + 1, end = len, mid;
            while (start <= end) {
                mid = (start + end) / 2;
                if (sumArr[mid] - sumArr[i] >= s) {
                    res = Math.min(res, mid - i);
                    end = mid - 1;
                } else
                    start = mid + 1;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    @Test
    public void simple1() {
        assertEquals(2, new Solution2().minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
    }

    @Test
    public void simple2() {
        assertEquals(3, new Solution2().minSubArrayLen(11, new int[] { 1, 2, 3, 4, 5 }));
    }
}
