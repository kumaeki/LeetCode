package kuma.p01.lc0120_Triangle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.Test;

public class Solution {
    // Runtime: 3 ms, faster than 42.62% of Java online submissions for Triangle.
    // Memory Usage: 40.2 MB, less than 8.16% of Java online submissions for Triangle.
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0)
            return 0;
        if (n == 1)
            return triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            List<Integer> list = triangle.get(i), pre = triangle.get(i - 1);
            list.set(0, list.get(0) + pre.get(0));
            list.set(i, list.get(i) + pre.get(i - 1));
            for (int j = 1; j < i; j++) {
                list.set(j, list.get(j) + Math.min(pre.get(j - 1), pre.get(j)));
            }
        }

        int res = Integer.MAX_VALUE;
        List<Integer> list = triangle.get(n - 1);
        for (int i = 0; i < n; i++)
            res = Math.min(res, list.get(i));

        return res;
    }

    @Test
    public void simple1() {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(Arrays.asList(new Integer[] { 2 }));
        triangle.add(Arrays.asList(new Integer[] { 3, 4 }));
        triangle.add(Arrays.asList(new Integer[] { 6, 5, 7 }));
        triangle.add(Arrays.asList(new Integer[] { 4, 1, 8, 3 }));
        assertEquals(11, new Solution().minimumTotal(triangle));
    }
}
