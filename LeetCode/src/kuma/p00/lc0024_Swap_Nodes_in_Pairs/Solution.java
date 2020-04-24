package kuma.p00.lc0024_Swap_Nodes_in_Pairs;

import kuma.common.ListNode;

public class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes
    // in Pairs.
    // Memory Usage: 37.3 MB, less than 5.50% of Java online submissions for Swap
    // Nodes in Pairs.
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
