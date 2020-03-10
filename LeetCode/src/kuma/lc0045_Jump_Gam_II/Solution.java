package kuma.lc0045_Jump_Gam_II;

public class Solution {
    public int jump2(int[] nums) {
        int res = 0, level = 0, rightmax = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            rightmax = Math.max(rightmax, i + nums[i]);
            if (i == level) {
                res++;
                level = rightmax;
            }
        }
        return res;
    }

}
