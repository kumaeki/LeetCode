package kuma.lc0023_Merge_k_Sorted_Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution3 {
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> list = new ArrayList<ListNode>();
        for (ListNode ln : lists) {
            if (ln != null)
                list.add(ln);
        }
        if (list.size() == 0)
            return null;

        Collections.sort(list, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1 == null ? 1 : o2 == null ? -1 : o1.val - o2.val;
            }
        });

        ListNode head = new ListNode(-1);
        ListNode node = head;

        while (!list.isEmpty()) {
            ListNode next = list.remove(0);
            if (next == null)
                break;

            node.next = next;
            node = node.next;
            next = next.next;
            if (next != null) {
                int target = next.val;
                int left = 0, right = list.size() - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    int midval = list.get(mid).val;
                    if (midval > target)
                        right = mid - 1;
                    else if (midval < target)
                        left = mid + 1;
                    else {
                        left = mid;
                        break;
                    }
                }
                list.add(left, next);
            }
        }

        return head.next;
    }
}
