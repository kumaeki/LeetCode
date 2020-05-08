package kuma.p01.lc0106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import java.util.*;

public class Solution2 {
    // Runtime: 1 ms, faster than 94.94% of Java online submissions for Construct
    // Binary Tree from Inorder and Postorder Traversal.
    // Memory Usage: 40.3 MB, less than 18.18% of Java online submissions for
    // Construct Binary Tree from Inorder and Postorder Traversal.
    Map<Integer, Integer> inmap;
    int index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        inmap = new HashMap<Integer, Integer>(n);
        index = n - 1;
        for (int i = 0; i < n; i++)
            inmap.put(inorder[i], i);

        return helper(inorder, 0, n - 1, postorder);
    }

    private TreeNode helper(int[] in, int left, int right, int[] post) {
        if (left > right)
            return null;
        int p = post[index--];
        TreeNode node = new TreeNode(p);
        if (left < right) {
            int index = inmap.get(p);
            node.right = helper(in, index + 1, right, post);
            node.left = helper(in, left, index - 1, post);
        }
        return node;
    }
}
