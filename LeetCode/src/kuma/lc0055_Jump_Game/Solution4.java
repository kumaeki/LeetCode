package kuma.lc0055_Jump_Game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution4 {
    public boolean canJump(int[] nums) {
        int len = nums.length, right = len - 1;
        for (int i = len - 2; i >= 0; i--) {
            if (i + nums[i] >= right)
                right = i;
        }
        return right == 0;
    }

    @Test
    public void testSimple1() {
        boolean expected = true;
        int[] nums = new int[] { 2, 3, 1, 1, 4 };
        boolean actual = new Solution4().canJump(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple2() {
        boolean expected = false;
        int[] nums = new int[] { 3, 2, 1, 0, 4 };
        boolean actual = new Solution4().canJump(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple3() {
        boolean expected = true;
        int[] nums = new int[] { 0 };
        boolean actual = new Solution4().canJump(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple4() {
        boolean expected = true;
        int[] nums = new int[] { 2, 0, 0 };
        boolean actual = new Solution4().canJump(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple5() {
        boolean expected = false;
        int[] nums = new int[] { 0, 2 };
        boolean actual = new Solution4().canJump(nums);
        assertEquals(expected, actual);
    }
}
