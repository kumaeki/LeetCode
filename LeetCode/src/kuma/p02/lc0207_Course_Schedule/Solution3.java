package kuma.p02.lc0207_Course_Schedule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

class Solution3 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] arrPre = new int[numCourses];
        for (int[] pr : prerequisites) {
            arrPre[pr[0]]++;
        }

        Queue<Integer> que = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++)
            if (arrPre[i] == 0) {
                que.offer(i);
            }
        int res = que.size();

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int[] pr : prerequisites) {
                if (pr[1] == cur && --arrPre[pr[0]] == 0) {
                    que.offer(pr[0]);
                    res++;
                }
            }
        }

        return res == numCourses;
    }

    @Test
    public void simple1() {
        boolean expected = false;
        boolean actual = new Solution3().canFinish(3, new int[][] { { 1, 0 }, { 1, 2 }, { 0, 1 } });
        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        boolean expected = false;
        boolean actual = new Solution3().canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } });
        assertEquals(expected, actual);
    }

    @Test
    public void simple3() {
        boolean expected = true;
        boolean actual = new Solution3().canFinish(3, new int[][] { { 1, 0 } });
        assertEquals(expected, actual);
    }
}
