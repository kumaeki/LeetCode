package kuma.p01.lc0145_Binary_Tree_Postorder_Traversal;

import java.util.*;

public class Solution3 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree
    // Postorder Traversal.
    // Memory Usage: 37.7 MB, less than 5.63% of Java online submissions for Binary
    // Tree Postorder Traversal.
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                list.add(root.val);
                root = root.right;
            } else {
                TreeNode node = stack.pop();
                root = node.left;
            }
        }
        Collections.reverse(list);
        return list;
    }

}
