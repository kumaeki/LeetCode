package kuma.p00.lc0086_Partition_List;

class Solution2 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Partition
    // List.
    // Memory Usage: 39 MB, less than 5.77% of Java online submissions for Partition
    // List.
    public ListNode partition(ListNode node, int x) {
        ListNode head1 = new ListNode(-1), node1 = head1, head2 = new ListNode(-1), node2 = head2;
        while (node != null) {
            if (node.val < x) {
                node1.next = node;
                node1 = node1.next;
            } else {
                node2.next = node;
                node2 = node2.next;
            }
            node = node.next;
        }
        node1.next = head2.next;
        node2.next = null;
        return head1.next;
    }
}
