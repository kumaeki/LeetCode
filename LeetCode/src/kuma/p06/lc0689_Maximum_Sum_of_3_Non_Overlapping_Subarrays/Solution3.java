package kuma.p06.lc0689_Maximum_Sum_of_3_Non_Overlapping_Subarrays;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class Solution3 {
    // Runtime: 2 ms, faster than 99.49% of Java online submissions for Maximum Sum
    // of 3 Non-Overlapping Subarrays.
    // Memory Usage: 41.9 MB, less than 52.94% of Java online submissions for
    // Maximum Sum of 3 Non-Overlapping Subarrays.
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len = nums.length - k + 1, sum = 0;
        int[] sum_k = new int[len];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k - 1) {
                sum_k[i - (k - 1)] = sum;
                sum -= nums[i - (k - 1)];
            }
        }

        int index = 0;
        int[] left = new int[len];
        for (int i = 0; i < len - 2 * k; i++) {
            if (sum_k[i] > sum_k[index])
                index = i;
            left[i] = index;
        }

        index = len - 1;
        int[] right = new int[len];
        for (int i = len - 1; i >= 2 * k - 1; i--) {
            if (sum_k[i] >= sum_k[index])
                index = i;
            right[i] = index;
        }

        int[] res = new int[3];
        int i, m, max = Integer.MIN_VALUE;
        for (int j = k; j < len - k; j++) {
            i = left[j - k];
            m = right[j + k];
            sum = sum_k[i] + sum_k[j] + sum_k[m];
            if (sum > max) {
                res[0] = i;
                res[1] = j;
                res[2] = m;
                max = sum;
            }
        }
        return res;
    }

    @Test
    public void simple1() {
        assertArrayEquals(new int[] { 0, 3, 5 },
                new Solution3().maxSumOfThreeSubarrays(new int[] { 1, 2, 1, 2, 6, 7, 5, 1 }, 2));
    }

    @Test
    public void simple2() {
        assertArrayEquals(new int[] { 1, 4, 7 },
                new Solution3().maxSumOfThreeSubarrays(new int[] { 7, 13, 20, 19, 19, 2, 10, 1, 1, 19 }, 3));
    }
}
