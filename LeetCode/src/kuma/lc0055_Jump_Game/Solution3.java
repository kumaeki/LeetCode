package kuma.lc0055_Jump_Game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution3 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len - 1];

        for (int i = 0; i < len - 1; i++) {
            dp[i] = i + nums[i];
            if (i > 0 && dp[i - 1] > dp[i])
                dp[i] = dp[i - 1];
            if (dp[i] == i)
                return false;
        }
        return true;
    }

    @Test
    public void testSimple1() {
        boolean expected = true;
        int[] nums = new int[] { 2, 3, 1, 1, 4 };
        boolean actual = new Solution3().canJump(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple2() {
        boolean expected = false;
        int[] nums = new int[] { 3, 2, 1, 0, 4 };
        boolean actual = new Solution3().canJump(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple3() {
        boolean expected = true;
        int[] nums = new int[] { 0 };
        boolean actual = new Solution3().canJump(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple4() {
        boolean expected = true;
        int[] nums = new int[] { 2, 0, 0 };
        boolean actual = new Solution3().canJump(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple5() {
        boolean expected = false;
        int[] nums = new int[] { 0, 2 };
        boolean actual = new Solution3().canJump(nums);
        assertEquals(expected, actual);
    }
}
