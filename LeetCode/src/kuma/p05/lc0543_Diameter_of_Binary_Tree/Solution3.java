package kuma.p05.lc0543_Diameter_of_Binary_Tree;

import java.util.*;

import kuma.p05.TreeNode;

public class Solution3 {
    // Runtime: 2 ms, faster than 15.28%
    public int diameterOfBinaryTree(TreeNode root) {
        // diameter map contains left or right
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        int[] res = new int[] { 0 };
        helper(root, res, map);
        return res[0];
    }

    private void helper(TreeNode node, int[] res, Map<TreeNode, Integer> map) {
        if (node == null) {
            map.put(null, -1);
            return;
        }
        if(map.containsKey(node))
            return;
        helper(node.left, res, map);
        helper(node.right, res, map);
        int left = map.get(node.left), right = map.get(node.right);
        res[0] = Math.max(res[0], left + right + 2);
        map.put(node, Math.max(left, right) + 1);
    }

}
