package kuma.p01.lc0144_Binary_Tree_Preorder_Traversal;

import java.util.*;

public class Solution2 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree
    // Preorder Traversal.
    // Memory Usage: 37.8 MB, less than 5.17% of Java online submissions for Binary
    // Tree Preorder Traversal.
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root != null)
            stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null)
                stack.push(node.right);
            if(node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }
}
