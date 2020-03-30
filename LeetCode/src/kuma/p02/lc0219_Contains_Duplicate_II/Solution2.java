package kuma.p02.lc0219_Contains_Duplicate_II;

import java.util.*;

class Solution2 {
    // Runtime: 5 ms, faster than 88.90% 
    // Memory Usage: 43.3 MB, less than 68.42% 
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.size() > k)
                set.remove(nums[i - k - 1]);
            if (!set.add(nums[i]))
                return true;
        }
        return false;
    }
}