package kuma.p00.lc0092_Reverse_Linked_List_II;

public class Solution2 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse
    // Linked List II.
    // Memory Usage: 37.3 MB, less than 11.36% of Java online submissions for
    // Reverse Linked List II.
    public ListNode reverseBetween(ListNode node, int m, int n) {
        if (node == null || node.next == null || m == n)
            return node;

        ListNode head = new ListNode(-1, node), pre = head;
        for (int i = 1; i < n; i++) {
            if (i < m) {
                pre = node;
                node = node.next;
            } else {
                ListNode temp = pre.next;

                pre.next = node.next;
                node.next = node.next.next;
                pre.next.next = temp;
            }
        }
        return head.next;
    }
}
