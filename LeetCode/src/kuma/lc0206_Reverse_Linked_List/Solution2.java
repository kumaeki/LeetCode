package kuma.lc0206_Reverse_Linked_List;

public class Solution2 {
    public ListNode reverseList(ListNode head) {
        return helper(head, null);
    }

    private ListNode helper(ListNode node1, ListNode node2) {
        if (node1 == null)
            return node2;
        ListNode next = node1.next;
        node1.next = node2;
        return helper(next, node1);
    }

}
