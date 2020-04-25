package kuma.p00.lc0025_Reverse_Nodes_in_k_Group;

import java.util.*;

import kuma.common.ListNode;

public class Solution2 {
    // Runtime: 1 ms, faster than 22.50% of Java online submissions for Reverse
    // Nodes in k-Group.
    // Memory Usage: 39.5 MB, less than 8.62% of Java online submissions for Reverse
    // Nodes in k-Group.
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = new ListNode(-1), pre = node, cur = head;
        LinkedList<ListNode> list = new LinkedList<ListNode>();
        while (cur != null) {
            for (int i = 0; i < k; i++) {
                if (cur == null) {
                    pre.next = list.isEmpty() ? null : list.peekFirst();
                    return node.next;
                }
                list.offerLast(cur);
                cur = cur.next;
            }
            while (!list.isEmpty()) {
                pre.next = list.peekLast();
                pre = list.pollLast();
            }
        }
        pre.next = null;
        return node.next;
    }

    public static void main(String[] args) {
        ListNode node = new Solution2().reverseKGroup(ListNode.getList(new int[] { 1, 2, 3, 4 }), 2);
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }
}
