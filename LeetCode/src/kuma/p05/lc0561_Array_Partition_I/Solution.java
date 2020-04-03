package kuma.p05.lc0561_Array_Partition_I;

import java.util.Arrays;

public class Solution {
    // Runtime: 10 ms, faster than 96.10% of Java online submissions for Array
    // Partition I.
    // Memory Usage: 42 MB, less than 85.71% of Java online submissions for Array
    // Partition I.
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0, len = nums.length; i < len; i = i + 2)
            sum += nums[i];
        return sum;
    }
}
