package kuma.p02.lc0238_Product_of_Array_Except_Self;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class Solution2 {
    // Runtime: 2 ms, faster than 16.69% of Java online submissions for Product of
    // Array Except Self.
    // Memory Usage: 48.3 MB, less than 5.51% of Java online submissions for Product
    // of Array Except Self.
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] order = new int[len], reverse = new int[len];
        order[0] = nums[0];
        reverse[len - 1] = nums[len - 1];
        for (int i = 1; i < len - 1; i++) {
            order[i] = order[i - 1] * nums[i];
            reverse[len - i - 1] = reverse[len - i] * nums[len - i - 1];
        }

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int left = (i == 0) ? 1 : order[i - 1];
            int right = (i == len - 1) ? 1 : reverse[i + 1];
            res[i] = left * right;
        }
        return res;
    }

    @Test
    public void simple1() {

        int[] expecteds = new int[] { 24, 12, 8, 6 };
        int[] nums = new int[] { 1, 2, 3, 4 };
        int[] actuals = new Solution2().productExceptSelf(nums);
        assertArrayEquals(expecteds, actuals);

    }
}
