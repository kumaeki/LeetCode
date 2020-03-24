package kuma.p03.lc0312_Burst_Balloons;

public class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        // get the new list without 0, contains the border(+2)
        int n = 1;
        int[] arr = new int[nums.length + 2];
        for (int num : nums)
            if (num != 0)
                arr[n++] = num;
        arr[0] = arr[n++] = 1;

        int[][] dp = new int[n][n];
        for (int right = 0; right < n; right++)
            for (int left = right; left >= 0; left--)
                for (int k = left + 1; k < right; k++)
                    dp[left][right] = Math.max(dp[left][right],
                            arr[left] * arr[k] * arr[right] + dp[left][k] + dp[k][right]);

        return dp[0][n - 1];
    }

}
