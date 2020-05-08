package kuma.p01.lc0109_Convert_Sorted_List_to_Binary_Search_Tree;

import java.util.*;

public class Solution {
    // Runtime: 1 ms, faster than 39.30% of Java online submissions for Convert
    // Sorted List to Binary Search Tree.
    // Memory Usage: 40.4 MB, less than 31.58% of Java online submissions for
    // Convert Sorted List to Binary Search Tree.
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return helper(list, 0, list.size() - 1);
    }

    private TreeNode helper(List<Integer> list, int left, int right) {
        if (left > right)
            return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = helper(list, left, mid - 1);
        node.right = helper(list, mid + 1, right);
        return node;
    }
}
