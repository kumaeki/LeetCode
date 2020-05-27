package kuma.p03.lc0307_Range_Sum_Query_Mutable;

public class NumArray3 {
    // Runtime: 8 ms, faster than 99.96% of Java online submissions for Range Sum
    // Query - Mutable.
    // Memory Usage: 45.9 MB, less than 87.50% of Java online submissions for Range
    // Sum Query - Mutable.
    int[] tree, nums;
    int n;

    public NumArray3(int[] nums) {
        this.n = nums.length;
        this.nums = new int[n];
        this.tree = new int[n + 1];
        for (int i = 0; i < n; i++)
            update(i, nums[i]);
    }

    private int getNext(int n) {
        return n & -n;
    }

    public void update(int i, int val) {
        int dif = val - nums[i];
        nums[i] = val;
        i++;
        while (i <= n) {
            tree[i] += dif;
            i += getNext(i);
        }
    }

    public int sumRange(int i, int j) {
        return getSum(j + 1) - getSum(i);
    }

    private int getSum(int i) {
        int res = 0;
        while (i > 0) {
            res += tree[i];
            i -= getNext(i);
        }
        return res;
    }

    public static void main(String[] args) {
        NumArray3 n = new NumArray3(new int[] { 1, 3, 5 });
        System.out.println(n.sumRange(0, 2));
        n.update(1, 2);
        System.out.println(n.sumRange(0, 2));
    }
}
