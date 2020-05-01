package kuma.p00.lc0090_Subsets_II;

import java.util.*;

public class Solution2 {
    // Runtime: 1 ms, faster than 99.62% of Java online submissions for Subsets II.
    // Memory Usage: 39.3 MB, less than 5.88% of Java online submissions for Subsets
    // II.
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int i) {
        res.add(list);
        for (int j = i; j < nums.length; j++) {
            if (j == i || nums[j] != nums[j - 1]) {
                List<Integer> co = new ArrayList<Integer>(list);
                co.add(nums[j]);
                helper(res, co, nums, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        new Solution2().subsetsWithDup(new int[] { 1, 1, 2, 2 }).forEach(x -> System.out.print(x));
        System.out.println("-----");
        new Solution2().subsetsWithDup(new int[] { 1, 1, 1 }).forEach(x -> System.out.print(x));
        System.out.println("-----");
        new Solution2().subsetsWithDup(new int[] {}).forEach(x -> System.out.print(x));
        System.out.println("-----");
        new Solution2().subsetsWithDup(new int[] { 1, 2, 2 }).forEach(x -> System.out.print(x));
    }
}
