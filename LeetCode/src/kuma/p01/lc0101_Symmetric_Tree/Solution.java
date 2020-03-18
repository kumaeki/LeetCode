package kuma.p01.lc0101_Symmetric_Tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> left = new Stack<TreeNode>(), right = new Stack<TreeNode>();
        left.push(root.left);
        right.push(root.right);
        while (!left.isEmpty()) {
            TreeNode l = left.pop(), r = right.pop();
            if (l == null && r == null)
                continue;
            if (l == null || r == null)
                return false;
            if (l.val != r.val)
                return false;
            left.push(l.left);
            left.push(l.right);
            right.push(r.right);
            right.push(r.left);
        }
        return true;
    }

    @Test
    public void simple() {
        boolean expected = false;

        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.right = right;

        boolean actual = new Solution().isSymmetric(root);
        assertEquals(expected, actual);
    }
}
