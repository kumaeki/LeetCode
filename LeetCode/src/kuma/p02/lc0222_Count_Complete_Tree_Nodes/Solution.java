package kuma.p02.lc0222_Count_Complete_Tree_Nodes;

public class Solution {
    // Runtime: 1 ms, faster than 16.90% of Java online submissions for Count
    // Complete Tree Nodes.
    // Memory Usage: 47.3 MB, less than 9.76% of Java online submissions for Count
    // Complete Tree Nodes.
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
