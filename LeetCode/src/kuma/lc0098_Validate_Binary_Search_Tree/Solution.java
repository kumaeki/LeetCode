package kuma.lc0098_Validate_Binary_Search_Tree;

import java.util.*;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        double pre = Double.NEGATIVE_INFINITY;
        while (!s.isEmpty() && root != null) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }

            root = s.pop();
            if (root.val >= pre)
                return false;
            root = root.right;
        }
        return true;
    }

}
