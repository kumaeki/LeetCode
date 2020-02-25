package kuma.lc0019_Remove_Nth_Node_From_End_of_List;

class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return getCount(head, n) == n ? head.next : head;
    }

    public int getCount(ListNode node, int n) {
        if (node == null)
            return 0;
        else {
            int count = getCount(node.next, n);
            if (count == n)
                node.next = node.next.next;
            return count + 1;
        }
    }
}
