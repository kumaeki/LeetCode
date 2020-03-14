package kuma.lc0198_House_Robber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int pre2 = nums[0], pre1 = nums[1];
        int res = Math.max(pre2, pre1);
        for(int i = 2; i < nums.length; i ++){
            res = Math.max(pre1, pre2 + nums[i]);
            pre2 = Math.max(pre1, pre2);
            pre1 = res;
        }
        return res;
    }

    @Test
    public void simple1() {

        int expected = 12;
        int[] nums = new int[] { 2, 7, 9, 3, 1 };
        int actual = new Solution().rob(nums);

        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {

        int expected = 4;
        int[] nums = new int[] { 1, 2, 3, 1 };
        int actual = new Solution().rob(nums);

        assertEquals(expected, actual);
    }

    @Test
    public void simple3() {

        int expected = 5;
        int[] nums = new int[] { 2, 1, 1, 3 };
        int actual = new Solution().rob(nums);

        assertEquals(expected, actual);
    }

    @Test
    public void simple4() {

        int expected = 19;
        int[] nums = new int[] { 3, 1, 7, 2, 9 };
        int actual = new Solution().rob(nums);

        assertEquals(expected, actual);
    }

    @Test
    public void simple5() {

        int expected = 2;
        int[] nums = new int[] { 1, 2 };
        int actual = new Solution().rob(nums);

        assertEquals(expected, actual);
    }
}
