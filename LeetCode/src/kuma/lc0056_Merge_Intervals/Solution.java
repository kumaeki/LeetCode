package kuma.lc0056_Merge_Intervals;

import java.util.Arrays;
import java.util.*;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2)
            return intervals;

        Arrays.sort(intervals, (o1, o2) -> (o1[0] - o2[0]));
        List<int[]> res = new ArrayList<int[]>(intervals.length);
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] itl = intervals[i];
            if (itl[0] <= right)
                right = Math.max(itl[1], right);
            else {
                res.add(new int[] { left, right });
                left = itl[0];
                right = itl[1];
            }
        }
        res.add(new int[] { left, right });

        return res.toArray(new int[res.size()][]);
    }
}
