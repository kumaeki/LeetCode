package kuma.p01.lc0137_Single_Number_II;

import java.util.*;

public class Solution {
    // Runtime: 4 ms, faster than 36.35% of Java online submissions for Single
    // Number II.
    // Memory Usage: 39.4 MB, less than 5.26% of Java online submissions for Single
    // Number II.
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            if (entry.getValue() == 1)
                return entry.getKey();

        return 0;
    }
}
