package kuma.p00.lc0045_Jump_Gam_II;

public class Solution3 {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++)
            dp[i] = len;
        boolean[] isVisited = new boolean[len];

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= i + nums[i] && j < len; j++) {
                if (isVisited[j])
                    continue;
                dp[j] = Math.min(dp[j], dp[i] + 1);
                if (j == len - 1)
                    return dp[j];
                isVisited[j] = true;
            }

        }

        return dp[len - 1];
    }
}
