package kuma.p06.lc0697_Degree_of_an_Array;

import java.util.*;

public class Solution {
    // Runtime: 36 ms, faster than 12.09% of Java online submissions for Degree of
    // an Array.
    // Memory Usage: 45.3 MB, less than 5.55% of Java online submissions for Degree
    // of an Array.

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            if (entry.getValue() > max)
                max = entry.getValue();

        List<Integer> list = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            if (entry.getValue() == max)
                list.add(entry.getKey());

        int len = nums.length, res = len;
        for (int val : list) {
            int left = 0, right = len - 1;
            while (left < right && nums[left] != val)
                left++;
            while (left < right && nums[right] != val)
                right--;
            res = Math.min(res, right - left + 1);
        }

        return res;
    }
}
