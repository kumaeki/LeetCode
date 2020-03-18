package kuma.p00.lc0039_Combination_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return helper(candidates, target, candidates.length - 1);
    }

    private List<List<Integer>> helper(int[] nums, int target, int right) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (target < 0 || right < 0)
            return res;

        int i = 0, j = right;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] <= target)
                i = mid + 1;
            else if (nums[mid] > target)
                j = mid - 1;
        }

        for (int k = i - 1; k >= 0; k--) {
            if (nums[k] == target) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(target);
                res.add(list);
            } else
                for (List<Integer> list : helper(nums, target - nums[k], k)) {
                    list.add(nums[k]);
                    res.add(list);
                }
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution2().combinationSum(new int[] { 2, 3, 5 }, 8);
    }
}
