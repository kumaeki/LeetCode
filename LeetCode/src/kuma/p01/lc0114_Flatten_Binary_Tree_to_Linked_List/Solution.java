package kuma.p01.lc0114_Flatten_Binary_Tree_to_Linked_List;

public class Solution {
    public void flatten(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
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
            node = node.right;
        }
    }
}
