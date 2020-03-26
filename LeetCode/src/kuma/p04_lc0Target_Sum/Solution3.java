package kuma.p04_lc0Target_Sum;

import java.util.*;

public class Solution3 {
    // Runtime: 10 ms, faster than 73.35%
    int[][] memo;

    public int findTargetSumWays(int[] nums, int S) {
        memo = new int[nums.length + 1][2001];
        for (int[] m : memo)
            Arrays.fill(m, Integer.MIN_VALUE);
        return helper(nums, S, 0, 0);
    }

    private int helper(int[] nums, int S, int index, int sum) {
        if (index == nums.length) {
            return sum == S ? 1 : 0;
        } else {
            int res = memo[index][sum + 1000];
            if (res != Integer.MIN_VALUE)
                return res;
            else {
                res = helper(nums, S, index + 1, sum + nums[index]) + helper(nums, S, index + 1, sum - nums[index]);
                memo[index][sum + 1000] = res;
                return res;
            }
        }
    }
}
