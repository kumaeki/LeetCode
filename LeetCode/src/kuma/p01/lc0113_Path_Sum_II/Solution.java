package kuma.p01.lc0113_Path_Sum_II;

import java.util.*;

public class Solution {
    // Runtime: 1 ms, faster than 99.98% of Java online submissions for Path Sum II.
    // Memory Usage: 40.1 MB, less than 18.18% of Java online submissions for Path
    // Sum II.
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, new ArrayList<Integer>(), root, sum);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, TreeNode node, int k) {
        if (node == null)
            return;
        int val = node.val;
        k -= val;
        list.add(node.val);
        if (node.left == null && node.right == null && k == 0) {
            res.add(new ArrayList<Integer>(list));
        } else {
            helper(res, list, node.left, k);
            helper(res, list, node.right, k);
        }
        list.remove(list.size() - 1);
    }
}
