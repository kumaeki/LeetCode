package kuma.lc0104_Maximum_Depth_of_Binary_Tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int res = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                TreeNode node = q.poll();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                size--;
            }
            res++;
        }
        return res;
    }

    @Test
    public void simple1() {
        int expected = 3;
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node2.left = node4;
        node3.right = node5;
        root.right = node3;
        root.left = node2;
        int actual = new Solution().maxDepth(root);
        assertEquals(expected, actual);
    }
}
