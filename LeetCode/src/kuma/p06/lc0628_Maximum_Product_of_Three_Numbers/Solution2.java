package kuma.p06.lc0628_Maximum_Product_of_Three_Numbers;

import java.util.Arrays;

public class Solution2 {
    // Runtime: 21 ms, faster than 5.34% of Java online submissions for Maximum
    // Product of Three Numbers.
    // Memory Usage: 52.1 MB, less than 7.14% of Java online submissions for Maximum
    // Product of Three Numbers.
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[0] * nums[1] * nums[len - 1], nums[len - 3] * nums[len - 2] * nums[len - 1]);
    }
}
