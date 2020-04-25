package kuma.p00.lc0025_Reverse_Nodes_in_k_Group;

import java.util.*;

import kuma.common.ListNode;

public class Solution {
    // Runtime: 1 ms, faster than 22.50% of Java online submissions for Reverse
    // Nodes in k-Group.
    // Memory Usage: 39.5 MB, less than 8.62% of Java online submissions for Reverse
    // Nodes in k-Group.
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = new ListNode(-1);
        helper(pre, head, k);
        return pre.next;
    }

    private void helper(ListNode pre, ListNode cur, int k) {
        LinkedList<ListNode> s = new LinkedList<ListNode>();
        for (int i = 0; i < k; i++) {
            if (cur == null) {
                pre.next = s.isEmpty() ? null : s.getFirst();
                return;
            }
            s.addLast(cur);
            cur = cur.next;
        }
        while (!s.isEmpty()) {
            pre.next = s.getLast();
            pre = s.removeLast();
        }
        helper(pre, cur, k);
    }

    public static void main(String[] args) {
        ListNode node = new Solution().reverseKGroup(ListNode.getList(new int[] { 1, 2, 3, 4 }), 2);
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }
}
