package kuma.p05.lc0560_Subarray_Sum_Equals_K;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class Solution4 {
    // Runtime: 212 ms, faster than 18.37% 
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;

        int len = nums.length;
        int count = 0, sum;
        for (int i = 0; i < len; i++) {
            sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }

    @Test
    public void simple1() {
        assertEquals(2, new Solution4().subarraySum(new int[] { 1, 1, 1 }, 2));
    }

    @Test
    public void simple2() {
        assertEquals(16, new Solution4().subarraySum(new int[] { 1, -1, 1, -1, 1, -1, 1, -1 }, 0));
    }
}
