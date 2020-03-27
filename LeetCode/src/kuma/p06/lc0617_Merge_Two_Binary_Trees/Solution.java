package kuma.p06.lc0617_Merge_Two_Binary_Trees;

import java.util.Stack;

import kuma.p06.TreeNode;

public class Solution {
    // Runtime: 1 ms, faster than 24.39%
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        Stack<TreeNode[]> stack = new Stack<TreeNode[]>();
        stack.push(new TreeNode[] { t1, t2 });
        while (!stack.isEmpty()) {
            TreeNode[] nodes = stack.pop();
            TreeNode n1 = nodes[0], n2 = nodes[1];
            if (n2 == null)
                continue;

            n1.val += n2.val;
            if (n1.left == null)
                n1.left = n2.left;
            else
                stack.push(new TreeNode[] { n1.left, n2.left });

            if (n1.right == null)
                n1.right = n2.right;
            else
                stack.push(new TreeNode[] { n1.right, n2.right });
        }
        return t1;
    }
}
