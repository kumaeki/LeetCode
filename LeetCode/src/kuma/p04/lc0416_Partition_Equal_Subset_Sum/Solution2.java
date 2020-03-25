package kuma.p04.lc0416_Partition_Equal_Subset_Sum;

import java.util.*;

public class Solution2 {
    // to slow, Time Limit Exceeded
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums)
            sum += num;
        return helper(nums, 0, sum, 0);
    }

    private boolean helper(int[] nums, int remain, int sum, int index) {
        if (remain == sum)
            return true;
        if (index >= nums.length / 2)
            return false;
        int num = nums[index++];
        return helper(nums, remain + num, sum - num, index) || helper(nums, remain, sum, index);
    }

}
