package kuma.p07.lc0713_Subarray_Product_Less_Than_K;

public class Solution3 {
    // Runtime: 7 ms, faster than 98.18% of Java online submissions for Subarray
    // Product Less Than K.
    // Memory Usage: 48.9 MB, less than 100.00% of Java online submissions for
    // Subarray Product Less Than K.
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k < 2)
            return 0;
        int pro = 1, res = 0, index = 0;
        for (int i = 0; i < nums.length; i++) {
            pro *= nums[i];
            while (pro >= k)
                pro /= nums[index++];
            res += (i - index + 1);
        }
        return res;
    }

}
