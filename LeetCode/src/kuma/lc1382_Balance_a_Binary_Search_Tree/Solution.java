package kuma.lc1382_Balance_a_Binary_Search_Tree;

import java.util.*;

public class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        insertIntoList(root, list);
        return getBST(list, 0, list.size() - 1);
    }

    private void insertIntoList(TreeNode node, List<TreeNode> list) {
        if (node != null) {
            insertIntoList(node.left, list);
            list.add(node);
            insertIntoList(node.right, list);
        }
    }

    private TreeNode getBST(List<TreeNode> list, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        TreeNode node = list.get(mid);
        node.left = getBST(list, start, mid - 1);
        node.right = getBST(list, mid + 1, end);
        return node;
    }
}
