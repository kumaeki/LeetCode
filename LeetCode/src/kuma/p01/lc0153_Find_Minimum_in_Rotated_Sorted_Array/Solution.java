package kuma.p01.lc0153_Find_Minimum_in_Rotated_Sorted_Array;

public class Solution {
    // Runtime: 0 ms, faster than 100.00%
    public int findMin(int[] nums) {
        int res = Integer.MAX_VALUE;
        for (int num : nums)
            if (num < res)
                res = num;
        return res;
    }
}
