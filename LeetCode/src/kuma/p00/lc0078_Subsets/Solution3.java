package kuma.p00.lc0078_Subsets;

import java.util.*;

public class Solution3 {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < len; i++) {
            List<List<Integer>> next = new ArrayList<List<Integer>>();
            for (List<Integer> list : res) {
                List<Integer> newlist = new ArrayList<Integer>(list);
                list.add(nums[i]);
                next.add(list);
                next.add(newlist);
            }
            res = next;
        }
        return res;
    }

}
