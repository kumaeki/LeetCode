package kuma.p04.lc0457_Circular_Array_Loop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

class Solution {
    // Runtime: 67 ms, faster than 10.99% of Java online submissions for Circular
    // Array Loop.
    // Memory Usage: 39.6 MB, less than 11.11% of Java online submissions for
    // Circular Array Loop.
    public boolean circularArrayLoop(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++)
            nums[i] = nums[i] % len;

        Set<Integer> set;
        int cur, next;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0)
                continue;
            cur = i;
            set = new HashSet<Integer>();
            set.add(i);
            while (true) {
                if (nums[i] * nums[cur] < 0)
                    break;
                next = (nums[cur] + cur + len) % len;
                if (next == cur)
                    break;
                if (!set.add(next))
                    return true;
                cur = next;
            }
        }
        return false;
    }

    @Test
    public void simple1() {
        assertEquals(true, new Solution().circularArrayLoop(new int[] { 2, -1, 1, 2, 2 }));
    }

    @Test
    public void simple2() {
        assertEquals(false, new Solution().circularArrayLoop(new int[] { -1, 2 }));
    }

    @Test
    public void simple3() {
        assertEquals(false, new Solution().circularArrayLoop(new int[] { -2, 1, -1, -2, -2 }));
    }

    @Test
    public void simple4() {
        assertEquals(true, new Solution().circularArrayLoop(new int[] { 1, 2, 3, 4, 5 }));
    }
}
