package kuma.p06.lc0617_Merge_Two_Binary_Trees;

import kuma.p06.TreeNode;

public class Solution2 {
    // Runtime: 0 ms, faster than 100.00% 
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);

        return node;
    }
}
