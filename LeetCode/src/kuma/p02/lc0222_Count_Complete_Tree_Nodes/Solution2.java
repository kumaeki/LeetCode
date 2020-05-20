package kuma.p02.lc0222_Count_Complete_Tree_Nodes;

public class Solution2 {
    // RRuntime: 0 ms, faster than 100.00% of Java online submissions for Count
    // Complete Tree Nodes.
    // Memory Usage: 47.2 MB, less than 9.76% of Java online submissions for Count
    // Complete Tree Nodes.
    public int countNodes(TreeNode root) {
        int left = getLevelLeft(root);
        if (left == getLevelRight(root))
            return (int) Math.pow(2, left) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);

    }

    private int getLevelLeft(TreeNode node) {
        int level = 0;
        while (node != null) {
            level++;
            node = node.left;
        }
        return level;
    }

    private int getLevelRight(TreeNode node) {
        int level = 0;
        while (node != null) {
            level++;
            node = node.right;
        }
        return level;
    }
}
