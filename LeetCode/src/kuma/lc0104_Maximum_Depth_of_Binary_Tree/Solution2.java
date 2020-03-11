package kuma.lc0104_Maximum_Depth_of_Binary_Tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Solution2 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    @Test
    public void simple1() {
        int expected = 2;
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.right = right;
        int actual = new Solution2().maxDepth(root);
        assertEquals(expected, actual);
    }
}
