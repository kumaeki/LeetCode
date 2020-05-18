package kuma.p02.lc0213_House_Robber_II;

public class Solution2 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for House
    // Robber II.
    // Memory Usage: 37 MB, less than 6.67% of Java online submissions for House
    // Robber II.
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];
        int[] dp1 = new int[3], dp2 = new int[3];
        dp1[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp1[2] = Math.max(dp1[1], dp1[0] + nums[i - 1]);
            dp1[0] = dp1[1];
            dp1[1] = dp1[2];
            dp2[2] = Math.max(dp2[1], dp2[0] + nums[i - 1]);
            dp2[0] = dp2[1];
            dp2[1] = dp2[2];
        }
        return Math.max(dp1[0], dp2[1]);
    }
}
