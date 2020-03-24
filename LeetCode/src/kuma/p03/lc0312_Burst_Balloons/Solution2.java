package kuma.p03.lc0312_Burst_Balloons;

public class Solution2 {
    int[][] memo;
    int[] arr;

    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        // get the new list without 0, contains the border(+2)
        int n = 1;
        arr = new int[nums.length + 2];
        for (int num : nums)
            if (num != 0)
                arr[n++] = num;
        arr[0] = arr[n++] = 1;

        memo = new int[n][n];
        return helper(0, n - 1);
    }

    private int helper(int left, int right) {
        // nothing but the border
        if (left + 1 == right)
            return 0;
        if (memo[left][right] > 0)
            return memo[left][right];
        int res = 0;
        for (int i = left + 1; i < right; i++)
            res = Math.max(res, arr[left] * arr[i] * arr[right] + helper(left, i) + helper(i, right));
        memo[left][right] = res;
        return res;
    }
}
