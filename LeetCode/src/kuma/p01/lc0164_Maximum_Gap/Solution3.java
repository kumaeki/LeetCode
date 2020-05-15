package kuma.p01.lc0164_Maximum_Gap;

public class Solution3 {
    // Runtime: 4 ms, faster than 31.13% of Java online submissions for Maximum Gap.
    // Memory Usage: 39.3 MB, less than 6.90% of Java online submissions for Maximum
    // Gap.
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        int max = nums[0], n = nums.length;

        for (int i = 1; i < n; i++)
            if (nums[i] > max)
                max = nums[i];

        int exp = 1, radix = 10;
        int[] storage = new int[n];
        while (max > 0) {
            int[] counts = new int[10];

            for (int i = 0; i < n; i++)
                counts[nums[i] / exp % radix]++;
            for (int i = 1; i < 10; i++)
                counts[i] += counts[i - 1];
            for (int i = n - 1; i >= 0; i--) {
                int index = --counts[nums[i] / exp % radix];
                storage[index] = nums[i];
            }
            for (int i = 0; i < n; i++)
                nums[i] = storage[i];
            max /= radix;
            exp *= radix;
        }

        int res = 0;
        for (int i = 1; i < n; i++)
            res = Math.max(res, nums[i] - nums[i - 1]);
        return res;
    }
}
