package kuma.p01.lc0199_Binary_Tree_Right_Side_View;

import java.util.*;

public class Solution2 {
    // Runtime: 1 ms, faster than 76.77% of Java online submissions for Binary Tree
    // Right Side View.
    // Memory Usage: 38.2 MB, less than 5.88% of Java online submissions for Binary
    // Tree Right Side View.
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Queue<Pair> que = new LinkedList<Pair>();
        que.offer(new Pair(root, 1));
        while (!que.isEmpty()) {
            Pair p = que.poll();
            if (p.node == null)
                continue;
            if (p.level > res.size())
                res.add(p.node.val);
            que.offer(new Pair(p.node.right, p.level + 1));
            que.offer(new Pair(p.node.left, p.level + 1));

        }
        return res;
    }

    class Pair {
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

}
