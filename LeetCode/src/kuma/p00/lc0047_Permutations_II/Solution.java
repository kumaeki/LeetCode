package kuma.p00.lc0047_Permutations_II;

import java.util.*;

public class Solution {
    // Runtime: 4 ms, faster than 29.97% of Java online submissions for Permutations
    // II.
    // Memory Usage: 46.1 MB, less than 5.97% of Java online submissions for
    // Permutations II.
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, nums, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] nums, int index) {
        if (index == nums.length)
            res.add(getList(nums));
        else {
            Set<Integer> set = new HashSet<Integer>();
            for (int i = index; i < nums.length; i++) {
                if (set.add(nums[i])) {
                    swap(nums, index, i);
                    helper(res, nums, index + 1);
                    swap(nums, index, i);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private List<Integer> getList(int[] nums) {
        List<Integer> list = new ArrayList<Integer>(nums.length);
        for (int num : nums)
            list.add(num);
        return list;
    }

    public static void main(String[] args) {
        new Solution().permuteUnique(new int[] { 1, 2, 3 });
    }
}
