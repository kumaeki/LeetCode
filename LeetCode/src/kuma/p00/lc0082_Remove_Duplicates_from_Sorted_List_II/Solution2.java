package kuma.p00.lc0082_Remove_Duplicates_from_Sorted_List_II;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class Solution2 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove
    // Duplicates from Sorted List II.
    // Memory Usage: 39 MB, less than 6.98% of Java online submissions for Remove
    // Duplicates from Sorted List II.
    public ListNode deleteDuplicates(ListNode node) {
        ListNode head = new ListNode(-1, node), pre = head;
        while (node != null) {
            while (node.next != null && node.next.val == node.val)
                node = node.next;

            if (pre.next != node)
                pre.next = node.next;
            else
                pre = node;

            node = node.next;
        }
        return head.next;
    }

    @Test
    public void simple1() {
        ListNode head = ListNode.getList(new int[] { 1, 2, 3, 3, 3, 5 });
        assertArrayEquals(new int[] { 1, 2, 5 }, ListNode.getArr(new Solution2().deleteDuplicates(head)));
    }
}
