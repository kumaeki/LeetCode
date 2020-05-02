package kuma.p00.lc0092_Reverse_Linked_List_II;

public class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse
    // Linked List II.
    // Memory Usage: 37.3 MB, less than 11.36% of Java online submissions for
    // Reverse Linked List II.
    public ListNode reverseBetween(ListNode node, int m, int n) {
        if (node == null || node.next == null || m == n)
            return node;

        ListNode head = new ListNode(-1, node), pre = head;
        int i = 1;
        while (i < m) {
            i++;
            pre = node;
            node = node.next;
        }
        while (i < n) {
            ListNode temp = pre.next;

            pre.next = node.next;
            node.next = node.next.next;
            pre.next.next = temp;
            i++;
        }
        return head.next;
    }
}
