package kuma.p04.lc0416_Partition_Equal_Subset_Sum;

public class Solution {
    // Runtime: 8 ms, faster than 83.88%
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if ((sum & 1) == 1)
            return false;

        int n = sum / 2 + 1;
        boolean[] dp = new boolean[n];
        dp[0] = true;

        for (int num : nums) {
            for (int j = n - 1; j >= 0; j--) {
                if (j - num >= 0)
                    dp[j] = dp[j] || dp[j - num];
            }
            if (dp[n - 1])
                return true;
        }
        return false;
    }

}
