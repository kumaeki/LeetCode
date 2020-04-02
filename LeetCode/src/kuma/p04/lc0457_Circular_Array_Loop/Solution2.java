package kuma.p04.lc0457_Circular_Array_Loop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Solution2 {
    // Runtime: 20 ms, faster than 45.77% of Java online submissions for Circular
    // Array Loop.
    // Memory Usage: 37.4 MB, less than 11.11% of Java online submissions for
    // Circular Array Loop.
    public boolean circularArrayLoop(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++)
            nums[i] = nums[i] % len;

        int slow, fast, next;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0)
                continue;

            slow = i;
            next = getNext(nums, slow);
            fast = getNext(nums, next);
            while (nums[i] * nums[next] > 0 && nums[i] * nums[fast] > 0) {
                if (slow == fast) {
                    if (slow == next)
                        break;
                    return true;
                }
                slow = getNext(nums, slow);
                next = getNext(nums, fast);
                fast = getNext(nums, next);
            }

            slow = i;
            while (nums[slow] * nums[i] > 0) {
                next = getNext(nums, slow);
                nums[slow] = 0;
                slow = next;
            }
        }
        return false;
    }

    private int getNext(int[] nums, int index) {
        return (nums[index] + index + nums.length) % nums.length;
    }

    @Test
    public void simple1() {
        assertEquals(true, new Solution2().circularArrayLoop(new int[] { 2, -1, 1, 2, 2 }));
    }

    @Test
    public void simple2() {
        assertEquals(false, new Solution2().circularArrayLoop(new int[] { -1, 2 }));
    }

    @Test
    public void simple3() {
        assertEquals(false, new Solution2().circularArrayLoop(new int[] { -2, 1, -1, -2, -2 }));
    }

    @Test
    public void simple4() {
        assertEquals(true, new Solution2().circularArrayLoop(new int[] { 1, 2, 3, 4, 5 }));
    }

    @Test
    public void simple5() {
        assertEquals(false, new Solution2().circularArrayLoop(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, -5 }));
    }
}
