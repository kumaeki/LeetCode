package kuma.lc0039_Combination_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return helper(candidates, target, 0);
    }

    private List<List<Integer>> helper(int[] nums, int target, int left) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (target < 0)
            return res;

        for (int i = left; i < nums.length; i++) {
            if (nums[i] == target) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(target);
                res.add(list);
            } else if(nums[i] < target)
                for (List<Integer> list : helper(nums, target - nums[i], i)) {
                    list.add(nums[i]);
                    res.add(list);
                }
            else
                break;
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().combinationSum(new int[] { 2, 3, 5 }, 8);
    }
}
