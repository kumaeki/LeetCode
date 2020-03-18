package kuma.p02.lc0207_Course_Schedule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] dp = new int[numCourses][numCourses];
        int[] arrPre = new int[numCourses];
        for (int[] pr : prerequisites) {
            int current = pr[1];
            int next = pr[0];
            dp[current][next] = 1;
            arrPre[next]++;
        }

        int res = 0;
        Queue<Integer> que = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++)
            if (arrPre[i] == 0) {
                que.offer(i);
                res++;
            }

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int i = 0; i < numCourses; i++) {
                if (dp[cur][i] == 1 && --arrPre[i] == 0) {
                    que.offer(i);
                    res++;
                }
            }
        }

        return res == numCourses;
    }

    @Test
    public void simple1() {
        boolean expected = false;
        boolean actual = new Solution2().canFinish(3, new int[][] { { 1, 0 }, { 1, 2 }, { 0, 1 } });
        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        boolean expected = false;
        boolean actual = new Solution2().canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } });
        assertEquals(expected, actual);
    }

    @Test
    public void simple3() {
        boolean expected = true;
        boolean actual = new Solution2().canFinish(3, new int[][] { { 1, 0 } });
        assertEquals(expected, actual);
    }
}
