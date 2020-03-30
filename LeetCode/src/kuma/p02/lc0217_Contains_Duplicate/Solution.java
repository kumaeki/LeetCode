package kuma.p02.lc0217_Contains_Duplicate;

import java.util.*;

public class Solution {
    // Runtime: 4 ms, faster than 81.51%
    // Memory Usage: 46.4 MB, less than 5.17%
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>(nums.length);
        for (int num : nums)
            if (!set.add(num))
                return true;
        return false;
    }
}
