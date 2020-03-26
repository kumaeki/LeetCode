package kuma.p05.lc0560_Subarray_Sum_Equals_K;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class Solution2 {
    // Runtime: 177 ms, faster than 30.12%
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;

        int len = nums.length;
        int[] arrSum = new int[len];
        arrSum[0] = nums[0];
        for (int i = 1; i < len; i++)
            arrSum[i] += arrSum[i - 1] + nums[i];

        int count = 0;
        for (int i = 0; i < len; i++) {
            if (arrSum[i] == k)
                count++;
            for (int j = 0; j < i; j++)
                if (arrSum[i] - arrSum[j] == k)
                    count++;
        }
        return count;
    }

    @Test
    public void simple1() {
        assertEquals(2, new Solution2().subarraySum(new int[] { 1, 1, 1 }, 2));
    }

    @Test
    public void simple2() {
        assertEquals(16, new Solution2().subarraySum(new int[] { 1, -1, 1, -1, 1, -1, 1, -1 }, 0));
    }
}
