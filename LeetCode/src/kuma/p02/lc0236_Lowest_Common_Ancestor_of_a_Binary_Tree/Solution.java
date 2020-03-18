package kuma.p02.lc0236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import java.util.*;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // traversal the tree
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        // keep the parents points
        Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
        map.put(root, null);

        // traversal the tree until find p and q
        while (!(map.containsKey(p) && map.containsKey(q))) {
            TreeNode node = stack.pop();

            if (node.left != null) {
                map.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                map.put(node.right, node);
                stack.push(node.right);
            }
        }

        Set<TreeNode> set = new HashSet<TreeNode>();
        while (p != null) {
            set.add(p);
            p = map.get(p);
        }

        while (!set.contains(q))
            q = map.get(q);

        return q;
    }

    @Test
    public void simple1() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        assertEquals(n1, new Solution().lowestCommonAncestor(n1, n3, n4));
    }
}
