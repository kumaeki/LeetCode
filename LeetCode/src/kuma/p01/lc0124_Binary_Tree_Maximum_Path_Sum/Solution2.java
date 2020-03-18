package kuma.p01.lc0124_Binary_Tree_Maximum_Path_Sum;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Solution2 {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        return root == null ? Integer.MIN_VALUE : Math.max(helper(root), max);
    }

    private int getMax(int[] nums) {
        int m = Integer.MIN_VALUE;
        for (int num : nums)
            if (num > m)
                m = num;
        return m;
    }

    private int helper(TreeNode node) {
        if (node == null)
            return 0;
        int val = node.val, left = helper(node.left), right = helper(node.right);
        int res = getMax(new int[] { node.val, val + left, val + right });
        max = getMax(new int[] { max, val + left + right, res });
        return res;
    }

    @Test
    public void simple1() {
        int expected = 6;
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        int actual = new Solution2().maxPathSum(root);
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
        int actual = new Solution2().maxPathSum(null);
        assertEquals(expected, actual);
    }
}
