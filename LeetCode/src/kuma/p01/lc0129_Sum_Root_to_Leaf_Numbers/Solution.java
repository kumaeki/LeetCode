package kuma.p01.lc0129_Sum_Root_to_Leaf_Numbers;

class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum Root to
    // Leaf Numbers.
    // Memory Usage: 37.4 MB, less than 5.13% of Java online submissions for Sum
    // Root to Leaf Numbers.
    public int sumNumbers(TreeNode root) {
        return helper(0, root);
    }

    private int helper(int val, TreeNode node) {
        if (node == null)
            return 0;

        val = 10 * val + node.val;
        if (node.left == null && node.right == null)
            return val;

        return helper(val, node.left) + helper(val, node.right);
    }
}
