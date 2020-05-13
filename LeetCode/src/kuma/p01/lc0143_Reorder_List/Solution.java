package kuma.p01.lc0143_Reorder_List;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class Solution {
    // Runtime: 1 ms, faster than 99.83% of Java online submissions for Reorder
    // List.
    // Memory Usage: 43.6 MB, less than 6.82% of Java online submissions for Reorder
    // List.
    public void reorderList(ListNode head) {
        if (head == null)
            return;
        ListNode low = head, fast = head;
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
        }
        ListNode cur = low.next;
        if (cur != null) {
            while (cur.next != null) {
                ListNode temp = low.next;
                low.next = cur.next;
                cur.next = cur.next.next;
                low.next.next = temp;
            }

            ListNode left = head, right = low.next;
            low.next = null;
            connect(left, right);
        }
    }

    private ListNode connect(ListNode left, ListNode right) {
        if (left == null)
            return right;
        if (right == null)
            return left;

        right.next = connect(left.next, right.next);
        left.next = right;
        return left;
    }

    @Test
    public void simple1() {
        Integer[] expecteds = new Integer[] { 1, 7, 2, 6, 3, 5, 4 };
        ListNode head = ListNode.generateNode(new int[] { 1, 2, 3, 4, 5, 6, 7 });
        new Solution().reorderList(head);
        Integer[] actuals = ListNode.generateList(head);
        assertArrayEquals(expecteds, actuals);
    }
}
