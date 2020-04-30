package kuma.p00.lc0086_Partition_List;

class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Partition
    // List.
    // Memory Usage: 39.2 MB, less than 5.77% of Java online submissions for
    // Partition List.
    public ListNode partition(ListNode node, int x) {
        ListNode head = new ListNode(-1, node), pre = head;
        while (node != null && node.next != null) {
            if (node.val < x) {
                pre = node;
                node = node.next;
            } else {
                while (node.next != null && node.next.val >= x)
                    node = node.next;
                if (node.next != null) {
                    ListNode next = node.next;
                    node.next = next.next;
                    next.next = pre.next;
                    pre.next = next;
                }
                pre = pre.next;
            }
        }
        return head.next;
    }
}
