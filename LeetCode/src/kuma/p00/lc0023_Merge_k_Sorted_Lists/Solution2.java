package kuma.p00.lc0023_Merge_k_Sorted_Lists;

import java.util.Arrays;
import java.util.Comparator;

public class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0)
            return null;

        Arrays.sort(lists, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1 == null ? 1 : o2 == null ? -1 : o1.val - o2.val;
            }
        });

        ListNode head = new ListNode(-1);
        if (lists[0] == null)
            return null;

        head.next = lists[0];
        lists[0] = lists[0].next;
        head.next.next = mergeKLists(lists);

        return head.next;
    }
}
