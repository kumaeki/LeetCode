package kuma.p05.lc0560_Subarray_Sum_Equals_K;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.Test;

public class Solution {
    // Runtime: 13 ms, faster than 45.43%
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;

        int len = nums.length;
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    @Test
    public void simple1() {
        assertEquals(2, new Solution().subarraySum(new int[] { 1, 1, 1 }, 2));
    }

    @Test
    public void simple2() {
        assertEquals(16, new Solution().subarraySum(new int[] { 1, -1, 1, -1, 1, -1, 1, -1 }, 0));
    }
}
