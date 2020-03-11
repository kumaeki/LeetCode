package kuma.lc0102_Binary_Tree_Level_Order_Traversal;

import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        helper(root, list, 0);
        return list;
    }

    private void helper(TreeNode node, List<List<Integer>> list, int level) {
        if (node == null)
            return;
        if (level >= list.size())
            list.add(new ArrayList<Integer>());
        list.get(level).add(node.val);
        helper(node.left, list, level + 1);
        helper(node.right, list, level + 1);
    }
}
