package kuma.p00.lc0090_Subsets_II;

import java.util.*;

public class Solution {
    // Runtime: 1 ms, faster than 99.62% of Java online submissions for Subsets II.
    // Memory Usage: 39.6 MB, less than 5.88% of Java online submissions for Subsets
    // II.
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = 0;
            if (i > 0 && nums[i] == nums[i - 1])
                start = pre;
            pre = res.size();
            for (int j = start, size = res.size(); j < size; j++) {
                List<Integer> list = new ArrayList<Integer>(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }
        }
        return res;
    }

    private List<List<Integer>> helper(int[] nums, int i) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (i == nums.length - 1) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(nums[i]);
            res.add(temp);
        } else if (i < nums.length - 1) {
            for (List<Integer> list : helper(nums, i + 1)) {
                res.add(new ArrayList<Integer>(list));
                if (nums[i] != nums[i + 1]) {
                    list.add(nums[i]);
                    res.add(list);
                }
            }
            if (nums[i] != nums[i + 1]) {
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().subsetsWithDup(new int[] { 1, 1, 2, 2 }).forEach(x -> System.out.print(x));
        System.out.println("-----");
        new Solution().subsetsWithDup(new int[] { 1, 1, 1 }).forEach(x -> System.out.print(x));
        System.out.println("-----");
        new Solution().subsetsWithDup(new int[] {}).forEach(x -> System.out.print(x));
        System.out.println("-----");
        new Solution().subsetsWithDup(new int[] { 1, 2, 2 }).forEach(x -> System.out.print(x));
    }
}
