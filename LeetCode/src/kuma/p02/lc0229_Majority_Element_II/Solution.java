package kuma.p02.lc0229_Majority_Element_II;

import java.util.*;

public class Solution {
    // Runtime: 8 ms, faster than 30.20% of Java online submissions for Majority
    // Element II.
    // Memory Usage: 42.7 MB, less than 7.27% of Java online submissions for
    // Majority Element II.

    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length, t = len / 3;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(len);
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        List<Integer> res = new ArrayList<Integer>(len);
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            if (entry.getValue() > t)
                res.add(entry.getKey());

        return res;
    }
}
