package kuma.p06.lc0621_Task_Scheduler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.Test;

public class Solution {
    // Runtime: 2 ms, faster than 99.58%
    public int leastInterval(char[] tasks, int n) {
        int[] remain = new int[26];
        for (char c : tasks)
            remain[c - 'A']++;
        Arrays.sort(remain);

        int max = remain[25] - 1, res = max * n;
        for (int i = 24; i >= 0 && remain[i] > 0; i--)
            res -= Math.min(max, remain[i]);
        return tasks.length + (res > 0 ? res : 0);
    }

    @Test
    public void simple1() {
        assertEquals(8, new Solution().leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 2));
    }

    @Test
    public void simple2() {
        assertEquals(104, new Solution().leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 50));
    }
}
