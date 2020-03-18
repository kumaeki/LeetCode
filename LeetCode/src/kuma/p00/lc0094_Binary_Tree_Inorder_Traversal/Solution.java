package kuma.p00.lc0094_Binary_Tree_Inorder_Traversal;

import java.util.*;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        TreeNode node = root;
        while(node != null) {
            if(node.left == null) {
                list.add(node.val);
                node = node.right;
            }else {
                TreeNode top = node.left;
                TreeNode right = node.left;
                while(right.right != null)
                    right = right.right;
                right.right = node;
                node.left = null;
                node = top;
            }
        }
        
        return list;
    }

}
