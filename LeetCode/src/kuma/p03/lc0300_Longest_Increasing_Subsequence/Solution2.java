package kuma.p03.lc0300_Longest_Increasing_Subsequence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            if (nums[i] > nums[i - 1])
                dp[i] = dp[i - 1] + 1;

            int j = i - 2;
            while (j >= 0) {
                while (j >= 0 && nums[i] <= nums[j])
                    j--;
                if (j >= 0)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                else
                    dp[i] = Math.max(dp[i], 1);
                j--;
            }

        }

        int max = dp[0];
        for (int i = 1; i < len; i++)
            max = Math.max(max, dp[i]);
        return max;
    }

    @Test
    public void simple1() {
        int expected = 4;
        int[] nums = new int[] { 10, 9, 2, 5, 3, 7, 101, 18 };
        int actual = new Solution2().lengthOfLIS(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        int expected = 1;
        int[] nums = new int[] { 4, 4, 4, 4 };
        int actual = new Solution2().lengthOfLIS(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void simple3() {
        int expected = 3;
        int[] nums = new int[] { 4, 10, 4, 3, 8, 9 };
        int actual = new Solution2().lengthOfLIS(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void simple4() {
        int expected = 2;
        int[] nums = new int[] { 3, 1, 2 };
        int actual = new Solution2().lengthOfLIS(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void simple5() {
        int expected = 6;
        int[] nums = new int[] { 1, 3, 6, 7, 9, 4, 10, 5, 6 };
        int actual = new Solution2().lengthOfLIS(nums);
        assertEquals(expected, actual);
    }
}
