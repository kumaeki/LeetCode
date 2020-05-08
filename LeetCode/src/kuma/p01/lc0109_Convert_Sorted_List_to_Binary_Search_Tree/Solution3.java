package kuma.p01.lc0109_Convert_Sorted_List_to_Binary_Search_Tree;

import java.util.*;

public class Solution3 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert
    // Sorted List to Binary Search Tree.
    // Memory Usage: 41.1 MB, less than 5.26% of Java online submissions for Convert
    // Sorted List to Binary Search Tree.
    ListNode node;

    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        node = head;
        while (head != null) {
            n++;
            head = head.next;
        }
        return helper(0, n - 1);
    }

    private TreeNode helper(int left, int right) {
        if (left > right)
            return null;
        int mid = (left + right) / 2;
        TreeNode nodeL = helper(left, mid - 1);

        TreeNode res = new TreeNode(node.val);
        node = node.next;
        res.left = nodeL;
        res.right = helper(mid + 1, right);

        return res;
    }
}
