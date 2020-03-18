package kuma.p01.lc0169_Majority_Element;

import java.util.*;

public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = nums.length / 2, count, res = 0;
        for (int num : nums) {
            count = map.getOrDefault(num, 0) + 1;
            if (count > len) {
                res = num;
                break;
            }
            map.put(num, count);
        }
        return res;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
