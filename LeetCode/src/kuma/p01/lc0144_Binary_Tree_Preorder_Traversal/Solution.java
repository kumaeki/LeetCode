package kuma.p01.lc0144_Binary_Tree_Preorder_Traversal;

import java.util.*;

public class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree
    // Preorder Traversal.
    // Memory Usage: 37.8 MB, less than 5.17% of Java online submissions for Binary
    // Tree Preorder Traversal.
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        helper(list, root);
        return list;
    }

    private void helper(List<Integer> list, TreeNode node) {
        if (node != null) {
            list.add(node.val);
            helper(list, node.left);
            helper(list, node.right);
        }
    }
}
