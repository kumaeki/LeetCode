package kuma.p02.lc0238_Product_of_Array_Except_Self;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[len - 1] = nums[len - 1];
        for (int i = len - 2; i > 0; i--)
            res[i] = res[i + 1] * nums[i];
        for (int i = 1; i < len; i++)
            nums[i] = nums[i] * nums[i - 1];

        res[0] = res[1];
        for (int i = 1; i < len - 1; i++)
            res[i] = res[i + 1] * nums[i - 1];
        res[len - 1] = nums[len - 2];
        return res;
    }

    @Test
    public void simple1() {

        int[] expecteds = new int[] { 24, 12, 8, 6 };
        int[] nums = new int[] { 1, 2, 3, 4 };
        int[] actuals = new Solution().productExceptSelf(nums);
        assertArrayEquals(expecteds, actuals);

    }
}
