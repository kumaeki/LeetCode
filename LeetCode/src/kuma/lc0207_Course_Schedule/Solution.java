package kuma.lc0207_Course_Schedule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

class Solution {
    // DFS , to slow
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>(numCourses);
        for (int[] pr : prerequisites) {
            List<Integer> list = map.getOrDefault(pr[1], new ArrayList<Integer>());
            list.add(pr[0]);
            map.put(pr[1], list);
        }

        boolean[] isVisited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++)
            if (isCirculation(map, isVisited, i))
                return false;

        return true;
    }

    private boolean isCirculation(Map<Integer, List<Integer>> map, boolean[] isVisited, int course) {
        if (isVisited[course])
            return true;
        else
            isVisited[course] = true;

        List<Integer> list = map.get(course);
        if (list != null) {
            for (int next : list) {
                if (isCirculation(map, isVisited, next))
                    return true;
            }
        }

        isVisited[course] = false;
        return false;
    }

    @Test
    public void simple1() {
        boolean expected = false;
        boolean actual = new Solution().canFinish(3, new int[][] { { 1, 0 }, { 1, 2 }, { 0, 1 } });
        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        boolean expected = false;
        boolean actual = new Solution().canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } });
        assertEquals(expected, actual);
    }

    @Test
    public void simple3() {
        boolean expected = true;
        boolean actual = new Solution().canFinish(3, new int[][] { { 1, 0 } });
        assertEquals(expected, actual);
    }
}
