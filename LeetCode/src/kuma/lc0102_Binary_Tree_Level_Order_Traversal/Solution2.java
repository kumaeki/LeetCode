package kuma.lc0102_Binary_Tree_Level_Order_Traversal;

import java.util.*;

public class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> l = new ArrayList<Integer>(size);
            while (size > 0) {
                TreeNode node = que.poll();
                if (node != null) {
                    l.add(node.val);
                    que.offer(node.left);
                    que.offer(node.right);
                }
                size--;
            }
            if (!l.isEmpty())
                list.add(l);
        }
        return list;
    }
}
