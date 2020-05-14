package kuma.p01.lc0144_Binary_Tree_Preorder_Traversal;

import java.util.*;

public class Solution3 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree
    // Preorder Traversal.
    // Memory Usage: 37.9 MB, less than 5.17% of Java online submissions for Binary
    // Tree Preorder Traversal.
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                list.add(root.val);
                stack.add(root);
                root = root.left;
            } else
                root = stack.pop().right;
        }
        return list;
    }
}
