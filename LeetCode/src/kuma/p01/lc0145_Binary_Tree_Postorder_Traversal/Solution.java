package kuma.p01.lc0145_Binary_Tree_Postorder_Traversal;

import java.util.*;

public class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree
    // Postorder Traversal.
    // Memory Usage: 37.4 MB, less than 5.63% of Java online submissions for Binary
    // Tree Postorder Traversal.
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        helper(root, list);
        return list;
    }

    public void helper(TreeNode node, List<Integer> list) {
        if (node != null) {
            helper(node.left, list);
            helper(node.right, list);
            list.add(node.val);
        }
    }
}
