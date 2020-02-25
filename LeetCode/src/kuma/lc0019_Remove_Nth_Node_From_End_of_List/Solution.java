package kuma.lc0019_Remove_Nth_Node_From_End_of_List;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode node = first;
        Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
        int i = 0;
        while (node != null) {
            map.put(i++, node);
            node = node.next;
        }

        int index = i - n - 1;
        if (n == 1)
            map.get(index).next = null;
        else
            map.get(index).next = map.get(index + 2);

        return first.next;
    }
}
