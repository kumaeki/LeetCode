package kuma.p00.lc0099_Recover_Binary_Search_Tree;

import java.util.Stack;

public class Solution {
    // Runtime: 3 ms, faster than 38.35% of Java online submissions for Recover
    // Binary Search Tree.
    // Memory Usage: 40 MB, less than 80.77% of Java online submissions for Recover
    // Binary Search Tree.
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null, first = null, second = null;
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (pre != null && pre.val > node.val) {
                if (first == null)
                    first = pre;
                second = node;
            }
            pre = node;
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }

        int i = first.val;
        first.val = second.val;
        second.val = i;
    }
}
