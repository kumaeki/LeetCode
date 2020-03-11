package kuma.lc0101_Symmetric_Tree;

class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;

        if (left == null || right == null)
            return false;

        if (left.val != right.val)
            return false;

        return helper(left.left, right.right) && helper(left.right, right.left);

    }
}
