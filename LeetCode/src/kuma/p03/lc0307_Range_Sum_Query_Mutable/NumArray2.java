package kuma.p03.lc0307_Range_Sum_Query_Mutable;

public class NumArray2 {
    // Runtime: 157 ms, faster than 10.79% of Java online submissions for Range Sum
    // Query - Mutable.
    // Memory Usage: 45 MB, less than 100.00% of Java online submissions for Range
    // Sum Query - Mutable.
    int[] org, preSum;

    public NumArray2(int[] nums) {
        int n = nums.length;
        org = nums;

        preSum = new int[n + 1];
        for (int i = 1; i <= n; i++)
            preSum[i] = preSum[i - 1] + nums[i - 1];

    }

    public void update(int i, int val) {
        int dif = org[i] - val;
        for (int j = i + 1; j < preSum.length; j++)
            preSum[j] -= dif;
        org[i] = val;
    }

    public int sumRange(int i, int j) {
        return preSum[j + 1] - preSum[i];
    }
}
