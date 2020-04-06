package kuma.p06.lc0628_Maximum_Product_of_Three_Numbers;

public class Solution {
    // Runtime: 5 ms, faster than 62.41% of Java online submissions for Maximum
    // Product of Three Numbers.
    // Memory Usage: 51.7 MB, less than 7.14% of Java online submissions for Maximum
    // Product of Three Numbers.
    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }

            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3)
                max3 = num;

        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}
