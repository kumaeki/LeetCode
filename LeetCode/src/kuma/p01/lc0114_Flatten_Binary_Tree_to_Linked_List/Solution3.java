package kuma.p01.lc0114_Flatten_Binary_Tree_to_Linked_List;

import java.util.*;

public class Solution3 {
    public void flatten(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            if (node == null)
                continue;
            if (node.left != null) {
                TreeNode left = node.left;
                if (node.right != null) {
                    while (left.right != null)
                        left = left.right;
                    left.right = node.right;
                }
                node.right = node.left;
                node.left = null;
            }
            s.push(node.right);
        }
    }
}
