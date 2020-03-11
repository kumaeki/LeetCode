package kuma.lc0098_Validate_Binary_Search_Tree;

import java.util.*;

public class Solution4 {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        helper(root, list);
        for (int i = 1; i < list.size(); i++)
            if (list.get(i) <= list.get(i - 1))
                return false;
        return true;
    }

    private void helper(TreeNode node, List<Integer> list) {
        if (node != null) {
            helper(node.left, list);
            list.add(node.val);
            helper(node.right, list);
        }
    }

}
