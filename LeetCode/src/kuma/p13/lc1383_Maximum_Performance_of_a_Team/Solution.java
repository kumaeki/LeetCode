package kuma.p13.lc1383_Maximum_Performance_of_a_Team;

import java.util.*;

public class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; i++)
            engineers[i] = new int[] { speed[i], efficiency[i] };

        Arrays.sort(engineers, (e1, e2) -> (e2[1] - e1[1]));

        long mod = (long) (1e9 + 7);
        long res = 0, totalSpeed = 0;
        PriorityQueue<Integer> que = new PriorityQueue<Integer>(k);
        for (int[] eng : engineers) {
            if (que.size() == k)
                totalSpeed -= que.poll();
            que.offer(eng[0]);
            totalSpeed += eng[0];
            res = Math.max(res, totalSpeed * eng[1]);
        }

        return (int) (res % mod);
    }
}