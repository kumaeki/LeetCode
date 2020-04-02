package kuma.p04.lc0457_Circular_Array_Loop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Solution4 {
    // Runtime: 28 ms, faster than 22.46% of Java online submissions for Circular
    // Array Loop.
    // Memory Usage: 36.6 MB, less than 11.11% of Java online submissions for
    // Circular Array Loop.
    public boolean circularArrayLoop(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++)
            nums[i] = nums[i] % len;

        for (int i = 0; i < len; i++) {
            if (nums[i] != 0 && helper(nums, i, (nums[i] + i + len) % len, i, len))
                return true;
        }
        return false;
    }

    private boolean helper(int[] nums, int pre, int cur, int start, int len) {
        if (pre == cur || nums[start] * nums[cur] < 0)
            return false;
        if (Math.abs(nums[cur]) > len)
            return true;
        int next = (nums[cur] + cur + nums.length) % nums.length;
        nums[cur] = nums[cur] + (nums[cur] > 0 ? len : -len);
        boolean res = helper(nums, cur, next, start, len);
        nums[cur] = nums[cur] % len;
        return res;
    }

    @Test
    public void simple1() {
        assertEquals(true, new Solution4().circularArrayLoop(new int[] { 2, -1, 1, 2, 2 }));
    }

    @Test
    public void simple2() {
        assertEquals(false, new Solution4().circularArrayLoop(new int[] { -1, 2 }));
    }

    @Test
    public void simple3() {
        assertEquals(false, new Solution4().circularArrayLoop(new int[] { -2, 1, -1, -2, -2 }));
    }

    @Test
    public void simple4() {
        assertEquals(true, new Solution4().circularArrayLoop(new int[] { 1, 2, 3, 4, 5 }));
    }

    @Test
    public void simple5() {
        assertEquals(true, new Solution4().circularArrayLoop(new int[] { 1, 1, 2 }));
    }
}
