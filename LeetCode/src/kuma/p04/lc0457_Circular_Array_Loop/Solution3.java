package kuma.p04.lc0457_Circular_Array_Loop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

class Solution3 {
    // Runtime: 103 ms, faster than 5.31% of Java online submissions for Circular
    // Array Loop.
    // Memory Usage: 40.4 MB, less than 11.11% of Java online submissions for
    // Circular Array Loop.
    public boolean circularArrayLoop(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++)
            nums[i] = nums[i] % len;

        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0 && helper(nums, set, i, (nums[i] + i + len) % len, i))
                return true;
        }
        return false;
    }

    private boolean helper(int[] nums, Set<Integer> set, int pre, int cur, int start) {
        if (pre == cur || nums[start] * nums[cur] < 0)
            return false;
        if (!set.add(cur))
            return true;
        boolean res = helper(nums, set, cur, (nums[cur] + cur + nums.length) % nums.length, start);
        set.remove(cur);
        return res;
    }

    @Test
    public void simple1() {
        assertEquals(true, new Solution3().circularArrayLoop(new int[] { 2, -1, 1, 2, 2 }));
    }

    @Test
    public void simple2() {
        assertEquals(false, new Solution3().circularArrayLoop(new int[] { -1, 2 }));
    }

    @Test
    public void simple3() {
        assertEquals(false, new Solution3().circularArrayLoop(new int[] { -2, 1, -1, -2, -2 }));
    }

    @Test
    public void simple4() {
        assertEquals(true, new Solution3().circularArrayLoop(new int[] { 1, 2, 3, 4, 5 }));
    }

    @Test
    public void simple5() {
        assertEquals(true, new Solution3().circularArrayLoop(new int[] { 1, 1, 2 }));
    }
}
