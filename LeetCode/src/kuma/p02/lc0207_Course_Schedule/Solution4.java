package kuma.p02.lc0207_Course_Schedule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

class Solution4 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // course route
        Map<Integer, List<Integer>> route = new HashMap<Integer, List<Integer>>(numCourses);
        // whether the course has  prerequisites
        int[] arrPre = new int[numCourses];
        for (int[] pr : prerequisites) {
            List<Integer> list = route.getOrDefault(pr[1], new ArrayList<Integer>());
            list.add(pr[0]);
            route.put(pr[1], list);
            arrPre[pr[0]]++;
        }

        // count the course that clear the prerequisites
        Queue<Integer> que = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++)
            if (arrPre[i] == 0) {
                que.offer(i);
            }
        int res = que.size();

        while (!que.isEmpty()) {
            int cur = que.poll();
            List<Integer> list = route.get(cur);
            if (list != null) {
                for (int next : list) {
                    if (--arrPre[next] == 0) {
                        que.offer(next);
                        res++;
                    }
                }
            }

        }

        return res == numCourses;
    }

    @Test
    public void simple1() {
        boolean expected = false;
        boolean actual = new Solution4().canFinish(3, new int[][] { { 1, 0 }, { 1, 2 }, { 0, 1 } });
        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        boolean expected = false;
        boolean actual = new Solution4().canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } });
        assertEquals(expected, actual);
    }

    @Test
    public void simple3() {
        boolean expected = true;
        boolean actual = new Solution4().canFinish(3, new int[][] { { 1, 0 } });
        assertEquals(expected, actual);
    }
}
