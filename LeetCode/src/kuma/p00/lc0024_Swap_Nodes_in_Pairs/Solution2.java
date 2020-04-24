package kuma.p00.lc0024_Swap_Nodes_in_Pairs;

import java.util.*;

import kuma.common.ListNode;

public class Solution2 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes
    // in Pairs.
    // Memory Usage: 36.7 MB, less than 5.50% of Java online submissions for Swap
    // Nodes in Pairs.
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode res = new ListNode(-1), pre = res, next;
        while (head != null && head.next != null) {
            next = head.next;
            head.next = next.next;
            next.next = head;
            pre.next = next;

            pre = head;
            head = head.next;
        }
        return res.next;
    }
}
