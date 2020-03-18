package kuma.p00.lc0045_Jump_Gam_II;

public class Solution2 {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++)
            dp[i] = len;

        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= nums[i] && i + j < len; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                if (i + j == len - 1)
                    return dp[len - 1];
            }

        }

        return dp[len - 1];
    }
}
