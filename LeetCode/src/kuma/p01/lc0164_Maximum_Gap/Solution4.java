package kuma.p01.lc0164_Maximum_Gap;

import java.util.Arrays;

public class Solution4 {
    // Runtime: 2 ms, faster than 93.62% of Java online submissions for Maximum Gap.
    // Memory Usage: 39.9 MB, less than 6.90% of Java online submissions for Maximum
    // Gap.
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        if (nums.length == 2)
            return Math.abs(nums[0] - nums[1]);

        int max = nums[0], min = nums[0], n = nums.length;

        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        if (max == min)
            return 0;
        int[] bucketMin = new int[n - 1], bucketMax = new int[n - 1];
        Arrays.fill(bucketMin, max);
        Arrays.fill(bucketMax, min);
        int w = (max - min) / (n - 1) + 1;
        for (int num : nums) {
            int index = (num - min) / w;
            bucketMin[index] = Math.min(bucketMin[index], num);
            bucketMax[index] = Math.max(bucketMax[index], num);
        }

        int res = 0, preMax = min;
        for (int i = 0; i < n - 1; i++) {
            if (bucketMax[i] == min)
                continue;
            res = Math.max(res, bucketMin[i] - preMax);
            preMax = bucketMax[i];
        }

        return res;
    }
}
