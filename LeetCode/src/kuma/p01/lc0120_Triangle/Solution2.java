package kuma.p01.lc0120_Triangle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.Test;

public class Solution2 {
    // Runtime: 1 ms, faster than 97.27% of Java online submissions for Triangle.
    // Memory Usage: 39.8 MB, less than 8.16% of Java online submissions for Triangle.
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0)
            return 0;
        int[] arr = new int[n], pre = new int[n];
        pre[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            List<Integer> list = triangle.get(i);
            arr[0] = list.get(0) + pre[0];
            arr[i] = list.get(i) + pre[i - 1];
            for (int j = 1; j < i; j++)
                arr[j] = list.get(j) + Math.min(pre[j - 1], pre[j]);
            pre = arr;
            arr = new int[n];
        }
        int res = Integer.MAX_VALUE;
        for (int val : pre)
            res = Math.min(res, val);
        return res;
    }

    @Test
    public void simple1() {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(Arrays.asList(new Integer[] { 2 }));
        triangle.add(Arrays.asList(new Integer[] { 3, 4 }));
        triangle.add(Arrays.asList(new Integer[] { 6, 5, 7 }));
        triangle.add(Arrays.asList(new Integer[] { 4, 1, 8, 3 }));
        assertEquals(11, new Solution2().minimumTotal(triangle));
    }
}
