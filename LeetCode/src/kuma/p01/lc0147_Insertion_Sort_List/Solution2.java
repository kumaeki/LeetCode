package kuma.p01.lc0147_Insertion_Sort_List;

public class Solution2 {
    // Runtime: 29 ms, faster than 56.39% of Java online submissions for Insertion
    // Sort List.
    // Memory Usage: 39.2 MB, less than 23.08% of Java online submissions for
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
        ListNode next = to;
        while (next.next != null && next.next.val <= cur.val) {
            next = next.next;
        }
        cur.next = next.next;
        next.next = cur;

        helper(to, from);
    }

}
