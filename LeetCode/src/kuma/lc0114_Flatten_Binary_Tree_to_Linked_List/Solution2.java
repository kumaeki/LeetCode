package kuma.lc0114_Flatten_Binary_Tree_to_Linked_List;

public class Solution2 {
    public void flatten(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                if (root.right == null) {
                    root.right = root.left;
                    root.left = null;

                } else {
                    TreeNode left = root.left;
                    while (left.right != null)
                        left = left.right;
                    left.right = root.right;
                    root.right = root.left;
                    root.left = null;
                }
            }
            flatten(root.right);
        }
    }
}
