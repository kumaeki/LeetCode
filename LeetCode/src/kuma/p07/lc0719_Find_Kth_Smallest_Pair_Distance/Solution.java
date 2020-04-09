package kuma.p07.lc0719_Find_Kth_Smallest_Pair_Distance;

class Solution {
    // Runtime: 590 ms, faster than 7.99% of Java online submissions for Find K-th
    // Smallest Pair Distance.
    // Memory Usage: 47.4 MB, less than 6.25% of Java online submissions for Find
    // K-th Smallest Pair Distance.
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums[0];
        for (int num : nums)
            if (num > n)
                n = num;
        int len = nums.length;
        int[] arr = new int[n + 1];
        for (int i = 0; i < len - 1; i++)
            for (int j = i + 1; j < len; j++)
                arr[Math.abs(nums[i] - nums[j])]++;

        int count = k;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0)
                count -= arr[i];
            if (count <= 0)
                return i;
        }
        return -1;
    }
}
