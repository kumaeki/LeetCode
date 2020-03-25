package kuma.p04.lc0437_Path_Sum_III;

import kuma.p04.TreeNode;

public class Solution2 {
    // Runtime: 21 ms, faster than 54.30%
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int helper(TreeNode node, int sum) {
        if (node == null)
            return 0;
        int dif = sum - node.val;
        return (dif == 0 ? 1 : 0) + helper(node.left, dif) + helper(node.right, dif);
    }
}
