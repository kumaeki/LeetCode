package kuma.p02.lc0217_Contains_Duplicate;

import java.util.*;

public class Solution2 {
    // Runtime: 3 ms, faster than 99.76%
    // Memory Usage: 43.6 MB, less than 75.86%
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++)
            if (nums[i] == nums[i - 1])
                return true;
        return false;
    }
}
