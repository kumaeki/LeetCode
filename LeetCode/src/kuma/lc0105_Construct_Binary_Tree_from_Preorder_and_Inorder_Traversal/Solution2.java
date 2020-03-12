package kuma.lc0105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import java.util.*;

public class Solution2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inmap = new HashMap<Integer, Integer>();
        int len = inorder.length;
        for (int i = 0; i < len; i++)
            inmap.put(inorder[i], i);

        return helper(preorder, inmap, 0, 0, len - 1);
    }

    private TreeNode helper(int[] preorder, Map<Integer, Integer> inmap, int preindex, int instart, int inend) {
        if (preindex >= preorder.length || instart > inend)
            return null;

        int val = preorder[preindex];
        int inindex = inmap.get(val);
        TreeNode node = new TreeNode(val);
        node.left = helper(preorder, inmap, preindex + 1, instart, inindex - 1);
        node.right = helper(preorder, inmap, preindex + 1 + inindex - instart, inindex + 1, inend);

        return node;
    }
}
