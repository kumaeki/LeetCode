package kuma.p01.lc0152_Maximum_Product_Subarray;

public class Solution2 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int len = nums.length;
        int product = 1, res = Integer.MIN_VALUE, resR = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            product *= nums[i];
            res = Math.max(res, product);
            if (product == 0)
                product = 1;
        }

        product = 1;
        for (int i = len - 1; i >= 0; i--) {
            product *= nums[i];
            resR = Math.max(resR, product);
            if (product == 0)
                product = 1;
        }
        return Math.max(resR, res);
    }
}
