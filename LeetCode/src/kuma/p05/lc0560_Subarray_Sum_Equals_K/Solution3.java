package kuma.p05.lc0560_Subarray_Sum_Equals_K;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class Solution3 {
    // Runtime: 234 ms, faster than 11.45%
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;

        int len = nums.length;
        int[] arrSum = new int[len + 1];
        arrSum[0] = 0;
        for (int i = 1; i <= len; i++)
            arrSum[i] = arrSum[i - 1] + nums[i - 1];

        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++)
                if (arrSum[j] - arrSum[i] == k)
                    count++;
        }
        return count;
    }

    @Test
    public void simple1() {
        assertEquals(2, new Solution3().subarraySum(new int[] { 1, 1, 1 }, 2));
    }

    @Test
    public void simple2() {
        assertEquals(16, new Solution3().subarraySum(new int[] { 1, -1, 1, -1, 1, -1, 1, -1 }, 0));
    }
}
