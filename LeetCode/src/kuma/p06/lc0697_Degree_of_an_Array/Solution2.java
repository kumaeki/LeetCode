package kuma.p06.lc0697_Degree_of_an_Array;

import java.util.*;

public class Solution2 {
    // Runtime: 11 ms, faster than 84.49% of Java online submissions for Degree of
    // an Array.
    // Memory Usage: 44.4 MB, less than 5.55% of Java online submissions for Degree
    // of an Array.

    public int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            List<Integer> list = map.getOrDefault(num, new ArrayList<Integer>());
            list.add(i);
            map.put(num, list);
        }
        int max = 0, res = len;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() > max) {
                max = list.size();
                res = list.get(list.size() - 1) - list.get(0) + 1;
            } else if (list.size() == max)
                res = Math.min(res, list.get(list.size() - 1) - list.get(0) + 1);
        }
        return res;
    }
}
