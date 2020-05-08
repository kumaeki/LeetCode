package kuma.p01.lc0106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import java.util.*;

public class Solution {
    // Runtime: 2 ms, faster than 65.69% of Java online submissions for Construct
    // Binary Tree from Inorder and Postorder Traversal.
    // Memory Usage: 40.2 MB, less than 20.00% of Java online submissions for
    // Construct Binary Tree from Inorder and Postorder Traversal.
    Map<Integer, Integer> inmap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        inmap = new HashMap<Integer, Integer>(n);
        for (int i = 0; i < n; i++)
            inmap.put(inorder[i], i);

        return helper(inorder, postorder, 0, n - 1);
    }

    private TreeNode helper(int[] in, int[] post, int left, int right) {
        if (left > right)
            return null;
        int p = post[right];
        TreeNode node = new TreeNode(p);
        if (left < right) {
            int index = inmap.get(p);
            int mid = right - 1;
            while (mid >= left) {
                if (inmap.get(post[mid]) < index) {
                    break;
                }
                mid--;
            }
            node.left = helper(in, post, left, mid);
            node.right = helper(in, post, mid + 1, right - 1);
        }
        return node;
    }
}
