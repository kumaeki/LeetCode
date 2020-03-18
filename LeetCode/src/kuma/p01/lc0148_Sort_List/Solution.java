package kuma.p01.lc0148_Sort_List;

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode fast = head, slow = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        head = sortList(head);
        slow = sortList(slow);

        return helper(head, slow);
    }

    private ListNode helper(ListNode n1, ListNode n2) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                node.next = n1;
                n1 = n1.next;
            } else {
                node.next = n2;
                n2 = n2.next;
            }
            node = node.next;
        }
        if (n1 != null)
            node.next = n1;
        else if (n2 != null)
            node.next = n2;
        return head.next;
    }
}
