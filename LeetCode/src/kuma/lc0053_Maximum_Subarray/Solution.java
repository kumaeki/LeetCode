package kuma.lc0053_Maximum_Subarray;

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int pre = nums[0], res = nums[0];
        for(int i = 1; i < nums.length; i++){
            pre = Math.max(pre + nums[i], nums[i]);
            res = Math.max(res, pre);
        }
        
        return res;
    }
}
