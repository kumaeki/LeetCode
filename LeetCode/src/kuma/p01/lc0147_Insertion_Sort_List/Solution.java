package kuma.p01.lc0147_Insertion_Sort_List;

public class Solution {
    // Runtime: 177 ms, faster than 5.58% of Java online submissions for Insertion
    // Sort List.
    // Memory Usage: 40.2 MB, less than 5.13% of Java online submissions for
    // Insertion Sort List.
    public ListNode insertionSortList(ListNode head) {
        ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
        helper(fakeHead, head);
        return fakeHead.next;
    }

    private void helper(ListNode to, ListNode from) {
        if (from == null)
            return;
        ListNode cur = from;
        from = from.next;
        cur.next = null;
        insert(to, cur);
        helper(to, from);
    }

    private void insert(ListNode head, ListNode node) {
        if (head.next == null)
            head.next = node;
        else {
            ListNode next = head.next;
            if (next.val <= node.val)
                helper(next, node);
            else {
                head.next = node;
                node.next = next;
            }
        }
    }
}
