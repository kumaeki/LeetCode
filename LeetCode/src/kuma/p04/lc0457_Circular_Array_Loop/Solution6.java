package kuma.p04.lc0457_Circular_Array_Loop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

class Solution6 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Circular
    // Array Loop.
    // Memory Usage: 37.3 MB, less than 11.11% of Java online submissions for
    // Circular Array Loop.
    public boolean circularArrayLoop(int[] nums) {
        int[] isVisited = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            if (isVisited[i] == 0 && helper(nums, isVisited, i))
                return true;
        return false;
    }

    private boolean helper(int[] nums, int[] isVisited, int cur) {
        if (isVisited[cur] == 2)
            return false;
        isVisited[cur] = 1;
        int next = getNext(nums, cur);
        if (cur == next || nums[cur] * nums[next] <= 0) {
            isVisited[cur] = 2;
            return false;
        }
        if (isVisited[next] == 1) {
            return true;
        }

        if (helper(nums, isVisited, next))
            return true;
        isVisited[cur] = 2;
        return false;
    }

    private int getNext(int[] nums, int index) {
        return (nums[index] % nums.length + index + nums.length) % nums.length;
    }

    @Test
    public void simple1() {
        assertEquals(true, new Solution6().circularArrayLoop(new int[] { 2, -1, 1, 2, 2 }));
    }

    @Test
    public void simple2() {
        assertEquals(false, new Solution6().circularArrayLoop(new int[] { -1, 2 }));
    }

    @Test
    public void simple3() {
        assertEquals(false, new Solution6().circularArrayLoop(new int[] { -2, 1, -1, -2, -2 }));
    }

    @Test
    public void simple4() {
        assertEquals(true, new Solution6().circularArrayLoop(new int[] { 1, 2, 3, 4, 5 }));
    }

    @Test
    public void simple5() {
        assertEquals(true, new Solution6().circularArrayLoop(new int[] { 1, -1, 2, 4, 4 }));
    }
}
