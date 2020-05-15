package kuma.p01.lc0173_Binary_Search_Tree_Iterator;

import java.util.*;

public class BSTIterator2 {
    // Runtime: 16 ms, faster than 48.09% of Java online submissions for Binary
    // Search Tree Iterator.
    // Memory Usage: 44.9 MB, less than 100.00% of Java online submissions for
    // Binary Search Tree Iterator.
    Stack<TreeNode> stack;
    TreeNode node;

    public BSTIterator2(TreeNode root) {
        stack = new Stack<TreeNode>();
        node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        TreeNode temp = stack.pop();
        node = temp.right;
        return temp.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return node != null || !stack.isEmpty();
    }

}
