package kuma.p02.lc0216_Combination_Sum_III;

import java.util.*;

public class Solution {
    // Runtime: 0 ms, faster than 100.00%
    // Memory Usage: 37 MB, less than 6.00%
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, new ArrayList<Integer>(), k, n, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int k, int n, int pre) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if (n <= 0 || k <= 0)
            return;
        for (int i = pre + 1; i <= 9; i++) {
            list.add(i);
            helper(res, list, k - 1, n - i, i);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        new Solution().combinationSum3(3, 9);
    }

}
