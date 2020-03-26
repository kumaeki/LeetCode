package kuma.p04.lc0494_lc0Target_Sum;

public class Solution2 {
    // Runtime: 519 ms, faster than 9.50% 
    public int findTargetSumWays(int[] nums, int S) {
        return helper(nums, S, 0, 0);
    }
    
    private int helper(int[] nums, int S, int index, int sum){
        if(index == nums.length)
            return sum == S ? 1 : 0;
        return helper(nums, S, index + 1, sum + nums[index]) 
            + helper(nums, S, index + 1, sum - nums[index]);
    }
}
