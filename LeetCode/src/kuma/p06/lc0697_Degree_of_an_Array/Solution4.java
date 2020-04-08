package kuma.p06.lc0697_Degree_of_an_Array;

import java.util.*;

public class Solution4 {
    // Runtime: 8 ms, faster than 93.07% of Java online submissions for Degree of an
    // Array.
    // Memory Usage: 43.6 MB, less than 16.67% of Java online submissions for Degree
    // of an Array.

    public int findShortestSubArray(int[] nums) {
        int len = nums.length;
        Map<Integer, int[]> map = new HashMap<Integer, int[]>(len);

        int degree = 1;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (!map.containsKey(num))
                map.put(num, new int[] { i, i, 1 });
            else {
                int[] pos = map.get(num);
                pos[1] = i;
                degree = Math.max(degree, ++pos[2]);
            }
        }
        int res = len;
        for (int[] pos : map.values())
            if (pos[2] == degree)
                res = Math.min(res, res = pos[1] - pos[0] + 1);

        return res;
    }
}
