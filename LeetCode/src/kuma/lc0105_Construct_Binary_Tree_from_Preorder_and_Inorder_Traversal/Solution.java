package kuma.lc0105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import java.util.*;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0)
            return null;

        Map<Integer, Integer> inmap = new HashMap<Integer, Integer>();
        int len = inorder.length;
        for (int i = 0; i < len; i++)
            inmap.put(inorder[i], i);

        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.add(root);
        for (int i = 1; i < len; i++) {
            int valCur = preorder[i];
            TreeNode nodeCur = new TreeNode(valCur);
            TreeNode nodePre = s.peek();
            if (inmap.get(valCur) < inmap.get(nodePre.val)) {
                nodePre.left = nodeCur;
            } else {
                while (!s.isEmpty() && inmap.get(valCur) > inmap.get(s.peek().val)) {
                    nodePre = s.pop();
                }
                nodePre.right = nodeCur;
            }
            s.push(nodeCur);
        }
        return root;
    }
}
