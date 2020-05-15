package kuma.p01.lc0173_Binary_Search_Tree_Iterator;

import java.util.*;

public class BSTIterator {
    int index;
    List<TreeNode> list;

    public BSTIterator(TreeNode root) {
        index = 0;
        list = new ArrayList<TreeNode>();
        generateList(list, root);

    }

    /** @return the next smallest number */
    public int next() {
        return list.get(index++).val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index < list.size();
    }

    // Runtime: 16 ms, faster than 48.09% of Java online submissions for Binary
    // Search Tree Iterator.
    // Memory Usage: 44.9 MB, less than 100.00% of Java online submissions for
    // Binary Search Tree Iterator.
    private void generateList(List<TreeNode> list, TreeNode node) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (node != null || !stack.isEmpty()) {
            if (node == null) {
                TreeNode temp = stack.pop();
                list.add(temp);
                node = temp.right;
            } else {
                stack.push(node);
                node = node.left;
            }
        }
    }
    // Runtime: 14 ms, faster than 99.86% of Java online submissions for Binary
    // Search Tree Iterator.
    // Memory Usage: 44.4 MB, less than 100.00% of Java online submissions for
    // Binary Search Tree Iterator.
//    private void generateList(List<TreeNode> list, TreeNode node) {
//        if (node == null)
//            return;
//        generateList(list, node.left);
//        list.add(node);
//        generateList(list, node.right);
//    }
}
