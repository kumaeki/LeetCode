package kuma.p03.lc0307_Range_Sum_Query_Mutable;

public class NumArray {
    // Runtime: 171 ms, faster than 7.64% of Java online submissions for Range Sum
    // Query - Mutable.
    // Memory Usage: 45.1 MB, less than 100.00% of Java online submissions for Range
    // Sum Query - Mutable.
    int[] org, preSum, dif;

    public NumArray(int[] nums) {
        int n = nums.length;
        org = nums;

        preSum = new int[n + 1];
        for (int i = 1; i <= n; i++)
            preSum[i] = preSum[i - 1] + nums[i - 1];

        dif = new int[n];
    }

    public void update(int i, int val) {
        dif[i] += org[i] - val;
        org[i] = val;
    }

    public int sumRange(int i, int j) {
        int res = preSum[j + 1] - preSum[i];

        for (int k = i; k <= j; k++)
            if (dif[k] != 0)
                res -= dif[k];

        return res;
    }
}
