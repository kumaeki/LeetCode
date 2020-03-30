package kuma.p01.lc0169_Majority_Element;

import java.util.*;

public class Solution2 {
    // Runtime: 1 ms, faster than 99.86%
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
