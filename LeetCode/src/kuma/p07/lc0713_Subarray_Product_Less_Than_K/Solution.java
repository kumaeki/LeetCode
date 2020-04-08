package kuma.p07.lc0713_Subarray_Product_Less_Than_K;

import java.util.*;

public class Solution {
    // Time Limit Exceeded
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        return helper(nums, k, 0, new ArrayList<Integer>());
    }

    private int helper(int[] nums, int k, int index, List<Integer> list) {
        if (index == nums.length)
            return 0;
        int num = nums[index];
        if (num >= k)
            return helper(nums, k, index + 1, new ArrayList<Integer>());
        else {
            List<Integer> l = new ArrayList<Integer>();
            l.add(num);
            for (int n : list) {
                int pro = n * num;
                if (pro < k)
                    l.add(pro);
            }
            return l.size() + helper(nums, k, index + 1, l);
        }
    }
}
