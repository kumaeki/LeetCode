package kuma.p00.lc0057_Insert_Interval;

import java.util.*;

class Solution2 {
    // Runtime: 1 ms, faster than 98.16% of Java online submissions for Insert
    // Interval.
    // Memory Usage: 41.7 MB, less than 68.75% of Java online submissions for Insert
    // Interval.
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = search(intervals, newInterval[0], 0), right = search(intervals, newInterval[1], 1);

        int n = intervals.length;
        List<int[]> res = new ArrayList<int[]>(n);
        for (int i = 0; i < left; i++)
            res.add(intervals[i]);

        if (left == 0 || newInterval[0] > intervals[left - 1][1])
            res.add(newInterval);

        int[] cur = res.get(res.size() - 1);
        cur[1] = Math.max(cur[1], newInterval[1]);

        if (right < n) {
            if (newInterval[1] >= intervals[right][0])
                cur[1] = intervals[right][1];
            else
                res.add(intervals[right]);

            for (int i = right + 1; i < n; i++)
                res.add(intervals[i]);
        }
        return res.toArray(new int[res.size()][]);
    }

    private int search(int[][] ins, int target, int index) {
        int l = 0, r = ins.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (ins[mid][index] < target)
                l = mid + 1;
            else if (ins[mid][index] > target)
                r = mid - 1;
            else
                return mid;
        }
        return l;
    }
}
