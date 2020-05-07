package kuma.p00.lc0099_Recover_Binary_Search_Tree;

import java.util.Stack;

public class Solution2 {
    // Runtime: 2 ms, faster than 79.68% of Java online submissions for Recover
    // Binary Search Tree.
    // Memory Usage: 40.1 MB, less than 80.77% of Java online submissions for
    // Recover Binary Search Tree.
    public void recoverTree(TreeNode root) {
        // arr : pre , first, second
        TreeNode[] arr = new TreeNode[3];
        helper(root, arr);

        int i = arr[1].val;
        arr[1].val = arr[2].val;
        arr[2].val = i;
    }

    private void helper(TreeNode node, TreeNode[] nodeArr) {
        if (node.left != null)
            helper(node.left, nodeArr);
        if (nodeArr[0] != null && nodeArr[0].val > node.val) {
            if (nodeArr[1] == null)
                nodeArr[1] = nodeArr[0];
            nodeArr[2] = node;
        }
        nodeArr[0] = node;
        if (node.right != null)
            helper(node.right, nodeArr);
    }
}
