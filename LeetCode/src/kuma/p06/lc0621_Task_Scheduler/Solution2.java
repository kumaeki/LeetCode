package kuma.p06.lc0621_Task_Scheduler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Solution2 {
    // Runtime: 5 ms, faster than 62.39%
    public int leastInterval(char[] tasks, int n) {
        int[] remain = new int[26];
        for (char c : tasks)
            remain[c - 'A']++;
        Arrays.parallelSort(remain);
        int res = 0;
        while (remain[25] > 0) {
            int cooldown = n;
            while (cooldown >= 0) {
                if (remain[25] == 0)
                    break;
                else {
                    if (n - cooldown < 26 && remain[25 - (n - cooldown)] > 0)
                        remain[25 - (n - cooldown)]--;
                    cooldown--;
                    res++;
                }
            }
            Arrays.parallelSort(remain);

        }
        return res;
    }

    @Test
    public void simple1() {
        assertEquals(8, new Solution2().leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 2));
    }

    @Test
    public void simple2() {
        assertEquals(104, new Solution2().leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 50));
    }
}
