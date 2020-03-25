package kuma.p04.lc0416_Partition_Equal_Subset_Sum;

import java.util.*;

public class Solution3 {
    // 41 ms, faster than 28.31%
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums)
            sum += num;
        if ((sum & 1) == 1)
            return false;

        int m = nums.length + 1;
        int n = sum / 2 + 1;
        boolean[][] dp = new boolean[m][n];
        for (int i = 0; i < m; i++)
            dp[i][0] = true;

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - nums[i - 1] >= 0)
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
            }
            if (dp[i][n - 1])
                return true;
        }
        return false;
    }

}
