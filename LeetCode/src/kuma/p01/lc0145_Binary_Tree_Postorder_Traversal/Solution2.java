package kuma.p01.lc0145_Binary_Tree_Postorder_Traversal;

import java.util.*;

public class Solution2 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree
    // Postorder Traversal.
    // Memory Usage: 38 MB, less than 5.63% of Java online submissions for Binary
    // Tree Postorder Traversal.
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            TreeNode pre = root;
            while (!stack.isEmpty()) {
                root = stack.peek();
                while (root.left != pre && root.right != pre && root.left != null) {
                    stack.push(root.left);
                    root = root.left;
                }
                if (root.right != pre && root.right != null) {
                    stack.push(root.right);
                    continue;
                }
                list.add(stack.pop().val);
                pre = root;
            }
        }
        return list;
    }

}
