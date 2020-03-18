package kuma.p02.lc0236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root.left == null && root.right == null)
            if (root == p)
                return p;
            else if (root == q)
                return q;
            else
                return null;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null)
            return (root == p || root == q) ? root : null;
        else if (left != null && right != null)
            return root;
        else if (root == p || root == q)
            return root;
        else
            return left != null ? left : right;
    }

    @Test
    public void simple1() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        assertEquals(n1, new Solution2().lowestCommonAncestor(n1, n3, n4));
    }
}
