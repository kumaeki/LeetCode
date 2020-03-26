package kuma.p06.lc0617_Merge_Two_Binary_Trees;

import kuma.p06.TreeNode;

public class Solution3 {
    // Runtime: 1 ms, faster than 24.39%
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;
        TreeNode node;
        if (t1 == null) {
            node = new TreeNode(t2.val);
            node.left = mergeTrees(null, t2.left);
            node.right = mergeTrees(null, t2.right);
        } else if (t2 == null) {
            node = new TreeNode(t1.val);
            node.left = mergeTrees(null, t1.left);
            node.right = mergeTrees(null, t1.right);
        } else {
            node = new TreeNode(t1.val + t2.val);
            node.left = mergeTrees(t1.left, t2.left);
            node.right = mergeTrees(t1.right, t2.right);
        }
        return node;
    }
}
