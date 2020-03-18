package kuma.p01.lc0124_Binary_Tree_Maximum_Path_Sum;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

public class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        Stack<TreeNode> s = new Stack<TreeNode>();
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.peek();
            boolean flg = true;
            if (node.left != null && !map.containsKey(node.left)) {
                s.push(node.left);
                flg = false;
            }
            if (node.right != null && !map.containsKey(node.right)) {
                s.push(node.right);
                flg = false;
            }
            if (flg) {
                s.pop();
                int val = node.val, left = map.getOrDefault(node.left, 0), right = map.getOrDefault(node.right, 0);
                int res = Math.max(Math.max(val, val + left), val + right);
                max = Math.max(Math.max(max, val + left + right), res);
                if (node != root)
                    res = Math.max(res, 0);
                map.put(node, res);
            }
        }
        return max;
    }

    @Test
    public void simple1() {
        int expected = 6;
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        int actual = new Solution().maxPathSum(root);
        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        int expected = Integer.MIN_VALUE;
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        int actual = new Solution().maxPathSum(null);
        assertEquals(expected, actual);
    }
}
