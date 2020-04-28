package kuma.p00.lc0057_Insert_Interval;

import java.util.*;

class Solution3 {
    // Runtime: 1 ms, faster than 98.16% of Java online submissions for Insert
    // Interval.
    // Memory Usage: 41.7 MB, less than 71.88% of Java online submissions for Insert
    // Interval.
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<int[]>(n);
        int index = 0;
        while (index < n && intervals[index][1] < newInterval[0])
            res.add(intervals[index++]);

        while (index < n && newInterval[1] >= intervals[index][0]) {
            int[] cur = intervals[index++];
            newInterval[0] = Math.min(newInterval[0], cur[0]);
            newInterval[1] = Math.min(newInterval[1], cur[1]);
        }
        res.add(newInterval);

        while (index < n)
            res.add(intervals[index++]);

        return res.toArray(new int[res.size()][]);
    }
}
