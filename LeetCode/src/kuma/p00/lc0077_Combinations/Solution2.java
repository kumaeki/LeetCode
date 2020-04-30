package kuma.p00.lc0077_Combinations;

import java.util.*;

public class Solution2 {
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for
    // Combinations.
    // Memory Usage: 40.5 MB, less than 43.48% of Java online submissions for
    // Combinations.
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, new ArrayList<Integer>(), n, k);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int n, int k) {
        if (k == 0)
            res.add(new ArrayList<Integer>(list));
        else {
            for (int i = n; i >= k; i--) {
                list.add(i);
                helper(res, list, i - 1, k - 1);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        new Solution2().combine(4, 2);
    }
}
