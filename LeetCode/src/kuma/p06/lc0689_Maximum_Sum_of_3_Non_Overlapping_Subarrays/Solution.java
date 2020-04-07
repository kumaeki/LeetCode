package kuma.p06.lc0689_Maximum_Sum_of_3_Non_Overlapping_Subarrays;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class Solution {
    // Time Limit Exceeded
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len = nums.length - k + 1, sum = 0;
        int[] dp = new int[len];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k - 1) {
                dp[i - (k - 1)] = sum;
                sum -= nums[i - (k - 1)];
            }
        }
        int[] res = null;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len - 2 * k; i++)
            for (int j = i + k; j < len - k; j++) {
                int left = dp[i] + dp[j];
                for (int m = j + k; m < len; m++) {
                    sum = left + dp[m];
                    if (sum > max) {
                        max = sum;
                        res = new int[] { i, j, m };
                    }
                }
            }
        return res;
    }

    @Test
    public void simple1() {
        assertArrayEquals(new int[] { 0, 3, 5 },
                new Solution().maxSumOfThreeSubarrays(new int[] { 1, 2, 1, 2, 6, 7, 5, 1 }, 2));
    }

    @Test
    public void simple2() {
        assertArrayEquals(new int[] { 1, 4, 7 },
                new Solution().maxSumOfThreeSubarrays(new int[] { 7, 13, 20, 19, 19, 2, 10, 1, 1, 19 }, 3));
    }
}
