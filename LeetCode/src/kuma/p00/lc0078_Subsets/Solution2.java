package kuma.p00.lc0078_Subsets;

import java.util.*;

public class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        return helper(nums, 0);
    }

    public List<List<Integer>> helper(int[] nums, int index) {
        List<List<Integer>> res;
        if (index == nums.length) {
            res = new ArrayList<List<Integer>>();
            List<Integer> list = new ArrayList<Integer>();
            res.add(list);
        } else {
            res = new ArrayList<List<Integer>>();
            for (List<Integer> list : helper(nums, index + 1)) {
                List<Integer> newlist = new ArrayList<Integer>(list);
                newlist.add(nums[index]);
                res.add(newlist);
                res.add(list);
            }
        }
        return res;
    }
}
