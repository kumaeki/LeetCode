package kuma.p00.lc0098_Validate_Binary_Search_Tree;

import java.util.Stack;

public class Solution3 {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();

            if (node.left != null) {
                if (getLeft(node.left).val >= node.val)
                    return false;
                s.push(node.left);
            }
            if (node.right != null) {
                if (getRight(node.right).val <= node.val)
                    return false;
                s.push(node.right);
            }
        }
        return true;

    }

    private TreeNode getLeft(TreeNode node) {
        while (node.right != null)
            node = node.right;

        return node;
    }

    private TreeNode getRight(TreeNode node) {
        while (node.left != null)
            node = node.left;

        return node;
    }
}
