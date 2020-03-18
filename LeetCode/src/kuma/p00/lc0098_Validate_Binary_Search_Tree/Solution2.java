package kuma.p00.lc0098_Validate_Binary_Search_Tree;

public class Solution2 {
    public boolean isValidBST(TreeNode root) {
        return root == null || ((helperLeft(root, root.left) && isValidBST(root.left))
                && (helperRight(root, root.right) && isValidBST(root.right)));
    }

    private boolean helperLeft(TreeNode node, TreeNode left) {
        if (left == null)
            return true;

        while (left.right != null)
            left = left.right;

        return node.val > left.val;
    }

    private boolean helperRight(TreeNode node, TreeNode right) {
        if (right == null)
            return true;

        while (right.left != null)
            right = right.left;

        return node.val < right.val;
    }
}
