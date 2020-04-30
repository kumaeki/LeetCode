package kuma.p00.lc0077_Combinations;

import java.util.*;

public class Solution {
    // Runtime: 2 ms, faster than 90.11% of Java online submissions for
    // Combinations.
    // Memory Usage: 40.8 MB, less than 36.96% of Java online submissions for
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
            for (int i = 0; i < n && n - i >= k - 1; i++) {
                list.add(n - i);
                helper(res, list, n - i - 1, k - 1);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        new Solution().combine(4, 2);
    }
}
