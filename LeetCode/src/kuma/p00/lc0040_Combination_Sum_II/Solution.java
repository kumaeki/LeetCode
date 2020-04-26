package kuma.p00.lc0040_Combination_Sum_II;

import java.util.*;

public class Solution {
    // Runtime: 10 ms, faster than 16.15% of Java online submissions for Combination
    // Sum II.
    // Memory Usage: 47.2 MB, less than 5.27% of Java online submissions for
    // Combination Sum II.
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < candidates.length; i++)
            if (i == 0 || candidates[i] != candidates[i - 1])
                helper(res, new ArrayList<Integer>(), candidates, i, target);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] cans, int index, int target) {
        if (index == cans.length || cans[index] > target)
            return;

        int can = cans[index];
        list.add(can);
        if (can == target)
            res.add(new ArrayList<Integer>(list));
        else
            for (int i = index + 1; i < cans.length; i++)
                if (i == index + 1 || cans[i] != cans[i - 1])
                    helper(res, new ArrayList<Integer>(list), cans, i, target - can);

    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Solution().combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8);
        for (List<Integer> list : res) {
            list.forEach(x -> System.out.print(x + ","));
            System.out.println("--------------------");
        }

    }
}
