package kuma.p05.lc0543_Diameter_of_Binary_Tree;

import kuma.p05.TreeNode;

public class Solution {
    // Runtime: 0 ms, faster than 100.00% 
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[] { 0 };
        helper(root, res);
        return res[0];
    }

    private int helper(TreeNode node, int[] res) {
        if (node == null) {
            return -1;
        }
        int left = helper(node.left, res), right = helper(node.right, res);
        res[0] = Math.max(res[0], left + right + 2);
        return Math.max(left, right) + 1;
    }

}
