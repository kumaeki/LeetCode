package kuma.p01.lc0113_Path_Sum_II;

import java.util.*;

public class Solution2 {
    // Runtime: 3 ms, faster than 13.76% of Java online submissions for Path Sum II.
    // Memory Usage: 40 MB, less than 18.18% of Java online submissions for Path Sum
    // II.
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                list.add(root.val);
                sum -= root.val;
                root = root.left;
            }
            root = stack.peek();
            if (root.right != null && root.right != pre) {
                root = root.right;
                continue;
            }
            if (root.left == null && root.right == null && sum == 0)
                res.add(new ArrayList<Integer>(list));

            pre = root;
            stack.pop();
            list.remove(list.size() - 1);
            sum += root.val;
            root = null;
        }

        return res;
    }

}
