package kuma.p01.lc0173_Binary_Search_Tree_Iterator;

import java.util.*;

public class BSTIterator3 {
    // Runtime: 15 ms, faster than 90.75% of Java online submissions for Binary
    // Search Tree Iterator.
    // Memory Usage: 44.3 MB, less than 100.00% of Java online submissions for
    // Binary Search Tree Iterator.
    Stack<TreeNode> stack;

    public BSTIterator3(TreeNode root) {
        stack = new Stack<TreeNode>();
        searchLeft(root);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode temp = stack.pop();
        searchLeft(temp.right);
        return temp.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void searchLeft(TreeNode node) {
        while (node != null) {
            stack.add(node);
            node = node.left;
        }
    }

}
