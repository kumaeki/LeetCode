package kuma.p05.lc0581_Shortest_Unsorted_Continuous_Subarray;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Stack;

import org.junit.Test;

public class Solution {
    // Runtime: 12 ms, faster than 20.43%
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int left = len - 1, right = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                left = Math.min(left, stack.pop());
            stack.push(i);
        }

        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                right = Math.max(right, stack.pop());
            stack.push(i);
        }
        return right > 0 ? right - left + 1 : 0;
    }

    @Test
    public void simple1() {
        int expected = 5;
        int[] nums = new int[] { 2, 6, 4, 8, 10, 9, 15 };
        int actual = new Solution().findUnsortedSubarray(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        int expected = 5;
        int[] nums = new int[] { 2, 1, 1, 1, 1 };
        int actual = new Solution().findUnsortedSubarray(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void simple3() {
        int expected = 0;
        int[] nums = new int[] {};
        int actual = new Solution().findUnsortedSubarray(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void simple4() {
        int expected = 4;
        int[] nums = new int[] { 3, 2, 3, 2, 4 };
        int actual = new Solution().findUnsortedSubarray(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void simple5() {
        int expected = 3;
        int[] nums = new int[] { 1, 2, 4, 5, 3 };
        int actual = new Solution().findUnsortedSubarray(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void simple6() {
        int expected = 5;
        int[] nums = new int[] { 2, 1, 3, 5, 4 };
        int actual = new Solution().findUnsortedSubarray(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void simple7() {
        int expected = 2;
        int[] nums = new int[] { 2, 1 };
        int actual = new Solution().findUnsortedSubarray(nums);
        assertEquals(expected, actual);
    }
}
