package kuma.p01.lc0124_Binary_Tree_Maximum_Path_Sum;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Solution3 {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode node) {
        if (node == null)
            return 0;
        int val = node.val;
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);
        max = Math.max(max, right + left + val);
        return Math.max(left, right) + val;
    }

    @Test
    public void simple1() {
        int expected = 6;
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        int actual = new Solution3().maxPathSum(root);
        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        int expected = Integer.MIN_VALUE;
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        int actual = new Solution3().maxPathSum(null);
        assertEquals(expected, actual);
    }
}
