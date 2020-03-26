package kuma.p05.lc0543_Diameter_of_Binary_Tree;

import java.util.*;

import kuma.p05.TreeNode;

public class Solution2 {
    // Runtime: 3 ms, faster than 14.45% 
    public int diameterOfBinaryTree(TreeNode root) {
        // diameter map contains left and right
        Map<TreeNode, Integer> map1 = new HashMap<TreeNode, Integer>();
        // diameter map contains left or right
        Map<TreeNode, Integer> map2 = new HashMap<TreeNode, Integer>();
        helper(root, map1, map2);
        int res = 0;
        for (int d : map1.values()) {
            if (res < d)
                res = d;
        }
        return res;
    }

    private void helper(TreeNode node, Map<TreeNode, Integer> map1, Map<TreeNode, Integer> map2) {
        if (node == null) {
            map1.put(null, 0);
            map2.put(null, -1);
            return;
        }
        if (map1.containsKey(node))
            return;
        helper(node.left, map1, map2);
        helper(node.right, map1, map2);
        int left = map2.get(node.left), right = map2.get(node.right);
        map1.put(node, left + right + 2);
        map2.put(node, Math.max(left, right) + 1);
    }

}
