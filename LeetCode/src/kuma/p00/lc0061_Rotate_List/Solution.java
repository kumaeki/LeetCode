package kuma.p00.lc0061_Rotate_List;

import kuma.common.ListNode;

public class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate
    // List.
    // Memory Usage: 38.9 MB, less than 46.55% of Java online submissions for Rotate
    // List.
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0)
            return head;
        ListNode node = head, tail = head;
        int n = 0;
        while (node != null) {
            n++;
            tail = node;
            node = node.next;
        }
        if (k % n == 0)
            return head;
        k = n - k % n;

        node = head;
        while (k-- > 1)
            node = node.next;
        ListNode next = node.next;

        tail.next = head;
        node.next = null;
        return next;
    }
}
