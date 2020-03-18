package kuma.p02.lc0206_Reverse_Linked_List;

import java.util.Stack;

public class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode pre = new ListNode(-1);
        Stack<ListNode> stack = new Stack<ListNode>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode node = pre;
        while (!stack.isEmpty()) {
            node.next = stack.pop();
            node = node.next;
        }
        node.next = null;
        return pre.next;
    }
}
