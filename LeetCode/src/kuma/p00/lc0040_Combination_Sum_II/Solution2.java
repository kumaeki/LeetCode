package kuma.p00.lc0040_Combination_Sum_II;

import java.util.*;

public class Solution2 {
    // Runtime: 9 ms, faster than 17.62% of Java online submissions for Combination
    // Sum II.
    // Memory Usage: 40.7 MB, less than 23.16% of Java online submissions for
    // Combination Sum II.
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, new ArrayList<Integer>(), candidates, 0, target);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] cans, int index, int target) {
        if (target == 0)
            res.add(new ArrayList<Integer>(list));
        else if (target > 0)
            for (int i = index; i < cans.length; i++)
                if (i == index || cans[i] != cans[i - 1]) {
                    list.add(cans[i]);
                    helper(res, list, cans, i + 1, target - cans[i]);
                    list.remove(list.size() - 1);
                }

    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Solution2().combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8);
        for (List<Integer> list : res) {
            list.forEach(x -> System.out.print(x + ","));
            System.out.println("--------------------");
        }

    }
}
