package kuma.p00.lc0094_Binary_Tree_Inorder_Traversal;

import java.util.*;

public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        helper(list, root);
        return list;
    }

    private void helper(List<Integer> list, TreeNode node) {
        if (node != null) {
            helper(list, node.left);
            list.add(node.val);
            helper(list, node.right);
        }
    }
}
