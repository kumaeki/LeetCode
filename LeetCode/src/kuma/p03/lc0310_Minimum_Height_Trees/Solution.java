package kuma.p03.lc0310_Minimum_Height_Trees;

import java.util.*;

public class Solution {
    // Runtime: 10 ms, faster than 93.15% of Java online submissions for Minimum
    // Height Trees.
    // Memory Usage: 44.2 MB, less than 94.44% of Java online submissions for
    // Minimum Height Trees.
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 0)
            return new ArrayList<Integer>();
        if (n == 1)
            return Arrays.asList(new Integer[] { 0 });
        if (n == 2)
            return Arrays.asList(new Integer[] { 0, 1 });
        List<List<Integer>> lists = new ArrayList<List<Integer>>(n);
        int[] degrees = new int[n];
        for (int i = 0; i < n; i++)
            lists.add(new ArrayList<Integer>());

        for (int[] edge : edges) {
            lists.get(edge[0]).add(edge[1]);
            lists.get(edge[1]).add(edge[0]);
            degrees[edge[0]]++;
            degrees[edge[1]]++;
        }

        List<Integer> pre = new ArrayList<Integer>(n);
        Queue<Integer> cur = new LinkedList<Integer>();
        for (int i = 0; i < n; i++)
            if (degrees[i] == 1)
                cur.add(i);

        while (!cur.isEmpty()) {
            pre.clear();
            pre.addAll(cur);

            for (int i = 0, l = cur.size(); i < l; i++) {
                int index = cur.poll();
                degrees[index]--;
                for (int next : lists.get(index))
                    if (--degrees[next] == 1)
                        cur.offer(next);
            }
        }

        return pre;
    }

    public static void main(String[] args) {
        new Solution().findMinHeightTrees(6, new int[][] { { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4 } });
    }

}
