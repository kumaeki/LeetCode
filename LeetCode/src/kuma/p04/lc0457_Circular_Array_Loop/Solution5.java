package kuma.p04.lc0457_Circular_Array_Loop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

class Solution5 {
    // Runtime: 1 ms, faster than 62.20% of Java online submissions for Circular
    // Array Loop.
    // Memory Usage: 37.1 MB, less than 11.11% of Java online submissions for
    // Circular Array Loop.
    public boolean circularArrayLoop(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++)
            nums[i] = nums[i] % len;

        Set<Integer> set = new HashSet<Integer>();
        int cur;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0)
                continue;
            cur = i;
            while (!set.contains(cur)) {
                if (nums[cur] * nums[i] <= 0)
                    break;
                set.add(cur);
                cur = getNext(nums, cur);
            }
            if (set.contains(cur) && cur != getNext(nums, cur))
                return true;
            for (int num : set)
                nums[num] = 0;
            set.clear();
        }
        return false;
    }

    private int getNext(int[] nums, int index) {
        return (nums[index] + index + nums.length) % nums.length;
    }

    @Test
    public void simple1() {
        assertEquals(true, new Solution5().circularArrayLoop(new int[] { 2, -1, 1, 2, 2 }));
    }

    @Test
    public void simple2() {
        assertEquals(false, new Solution5().circularArrayLoop(new int[] { -1, 2 }));
    }

    @Test
    public void simple3() {
        assertEquals(false, new Solution5().circularArrayLoop(new int[] { -2, 1, -1, -2, -2 }));
    }

    @Test
    public void simple4() {
        assertEquals(true, new Solution5().circularArrayLoop(new int[] { 1, 2, 3, 4, 5 }));
    }

    @Test
    public void simple5() {
        assertEquals(true, new Solution5().circularArrayLoop(new int[] { 1, -1, 2, 4, 4 }));
    }
}
