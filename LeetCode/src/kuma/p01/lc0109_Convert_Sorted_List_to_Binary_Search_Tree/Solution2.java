package kuma.p01.lc0109_Convert_Sorted_List_to_Binary_Search_Tree;

public class Solution2 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert
    // Sorted List to Binary Search Tree.
    // Memory Usage: 41.1 MB, less than 5.26% of Java online submissions for Convert
    // Sorted List to Binary Search Tree.
    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode node = head;
        while (node != null) {
            n++;
            node = node.next;
        }
        int[] list = new int[n];
        int i = 0;
        while (head != null) {
            list[i++] = head.val;
            head = head.next;
        }
        return helper(list, 0, n - 1);
    }

    private TreeNode helper(int[] list, int left, int right) {
        if (left > right)
            return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(list[mid]);
        node.left = helper(list, left, mid - 1);
        node.right = helper(list, mid + 1, right);
        return node;
    }
}
