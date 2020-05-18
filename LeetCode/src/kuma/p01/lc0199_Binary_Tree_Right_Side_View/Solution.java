package kuma.p01.lc0199_Binary_Tree_Right_Side_View;

import java.util.*;

public class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree
    // Right Side View.
    // Memory Usage: 39.5 MB, less than 5.88% of Java online submissions for Binary
    // Tree Right Side View.
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        generateList(res, root, 1);
        return res;
    }

    private void generateList(List<Integer> list, TreeNode node, int level) {
        if (node == null)
            return;
        if (level > list.size())
            list.add(node.val);
        generateList(list, node.right, level + 1);
        generateList(list, node.left, level + 1);
    }
}
