package kuma.p01.lc0147_Insertion_Sort_List;

import java.util.*;

public class Solution4 {
    // Runtime: 3 ms, faster than 81.24% of Java online submissions for Insertion
    // Sort List.
    // Memory Usage: 39.6 MB, less than 17.95% of Java online submissions for
    // Insertion Sort List.
    public ListNode insertionSortList(ListNode head) {
        List<ListNode> list = new ArrayList<ListNode>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        Collections.sort(list, (x, y) -> (x.val - y.val));
        ListNode fakeHead = new ListNode(Integer.MIN_VALUE), cur = fakeHead;
        for (ListNode n : list) {
            cur.next = n;
            cur = cur.next;
        }
        cur.next = null;
        return fakeHead.next;
    }
}
