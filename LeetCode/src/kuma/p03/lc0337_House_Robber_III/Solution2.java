package kuma.p03.lc0337_House_Robber_III;

import kuma.p03.TreeNode;

public class Solution2 {
    public int rob(TreeNode root) {
        return Math.max(helper(root, false), helper(root, true));
    }

    public int helper(TreeNode node, boolean robbed) {
        if (node == null)
            return 0;
        // rob the house
        if (robbed) {
            return node.val + helper(node.left, false) + helper(node.right, false);
        }
        // do not rob the house
        else {
            return Math.max(helper(node.left, true), helper(node.left, false))
                    + Math.max(helper(node.right, true), helper(node.right, false));
        }
    }
}
