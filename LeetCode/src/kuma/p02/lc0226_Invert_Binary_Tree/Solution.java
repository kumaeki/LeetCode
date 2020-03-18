package kuma.p02.lc0226_Invert_Binary_Tree;

import java.util.*;

public class Solution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);

        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            if (node != null) {
                TreeNode left = node.left;
                node.left = node.right;
                node.right = left;
                que.offer(node.left);
                que.offer(node.right);
            }

        }
        return root;
    }
}
