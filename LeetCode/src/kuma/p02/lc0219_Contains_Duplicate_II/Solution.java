package kuma.p02.lc0219_Contains_Duplicate_II;

import java.util.*;

class Solution {
    // Runtime: 6 ms, faster than 64.41%
    // Memory Usage: 45.6 MB, less than 5.26%
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k)
                return true;
            else
                map.put(num, i);
        }
        return false;
    }
}