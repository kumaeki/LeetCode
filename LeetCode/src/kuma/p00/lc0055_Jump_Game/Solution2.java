package kuma.p00.lc0055_Jump_Game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution2 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
            return true;

        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[0] = true;

        for (int i = 0; i < len; i++) {
            if (dp[i]) {
                for (int k = i + 1; k <= i + nums[i] && k < len; k++)
                    if (!dp[k])
                        dp[k] = true;
            }
            if (dp[len - 1])
                return true;
        }
        return false;
    }

    @Test
    public void testSimple1() {
        boolean expected = true;
        int[] nums = new int[] { 2, 3, 1, 1, 4 };
        boolean actual = new Solution2().canJump(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple2() {
        boolean expected = false;
        int[] nums = new int[] { 3, 2, 1, 0, 4 };
        boolean actual = new Solution2().canJump(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple3() {
        boolean expected = true;
        int[] nums = new int[] { 0 };
        boolean actual = new Solution2().canJump(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple4() {
        boolean expected = true;
        int[] nums = new int[] { 2, 0, 0 };
        boolean actual = new Solution2().canJump(nums);
        assertEquals(expected, actual);
    }
}
