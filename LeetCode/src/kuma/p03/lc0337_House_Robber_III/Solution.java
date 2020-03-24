package kuma.p03.lc0337_House_Robber_III;

import kuma.p03.TreeNode;

public class Solution {

    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    // result[0] -> rob the house
    // result[1] -> skip the house
    public int[] helper(TreeNode node) {
        int[] res = new int[2];
        if (node != null) {
            int[] left = helper(node.left), right = helper(node.right);
            res[0] = node.val + left[1] + right[1];
            res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        }
        return res;

    }
}
