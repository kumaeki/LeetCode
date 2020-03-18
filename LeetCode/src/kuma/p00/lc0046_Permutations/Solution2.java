package kuma.p00.lc0046_Permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        return helper(nums, 0);
    }

    public List<List<Integer>> helper(int[] nums, int index) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            List<Integer> list = new ArrayList<Integer>();
            res.add(list);
        } else if (index == nums.length - 1) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(nums[index]);
            res.add(list);
        } else {
            int num = nums[index];
            for (List<Integer> list : helper(nums, index + 1)) {
                for (int i = 0; i <= list.size(); i++) {
                    List<Integer> l = new ArrayList<Integer>(list);
                    l.add(i, num);
                    res.add(l);
                }
            }
        }
        return res;
    }
}
