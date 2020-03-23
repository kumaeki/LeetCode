package kuma.p02.lc0300_Longest_Increasing_Subsequence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution3 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int len = nums.length, res = 1;
        int[] dp = new int[len];
        dp[0] = 1;

        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    @Test
    public void simple1() {
        int expected = 4;
        int[] nums = new int[] { 10, 9, 2, 5, 3, 7, 101, 18 };
        int actual = new Solution3().lengthOfLIS(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        int expected = 1;
        int[] nums = new int[] { 4, 4, 4, 4 };
        int actual = new Solution3().lengthOfLIS(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void simple3() {
        int expected = 3;
        int[] nums = new int[] { 4, 10, 4, 3, 8, 9 };
        int actual = new Solution3().lengthOfLIS(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void simple4() {
        int expected = 2;
        int[] nums = new int[] { 3, 1, 2 };
        int actual = new Solution3().lengthOfLIS(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void simple5() {
        int expected = 6;
        int[] nums = new int[] { 1, 3, 6, 7, 9, 4, 10, 5, 6 };
        int actual = new Solution3().lengthOfLIS(nums);
        assertEquals(expected, actual);
    }
}
