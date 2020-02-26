package kuma.lc0023_Merge_k_Sorted_Lists;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        return helper1(lists, 0, lists.length - 1);
    }

    private ListNode helper1(ListNode[] list, int left, int right) {
        if (left == right)
            return list[left];
        else {
            int mid = (left + right) / 2;
            ListNode l1 = helper1(list, left, mid);
            ListNode l2 = helper1(list, mid + 1, right);
            return helper2(l1, l2);
        }
    }

    private ListNode helper2(ListNode n1, ListNode n2) {
        if (n1 == null)
            return n2;
        if (n2 == null)
            return n1;

        if (n1.val < n2.val) {
            n1.next = helper2(n1.next, n2);
            return n1;
        } else {
            n2.next = helper2(n1, n2.next);
            return n2;
        }
    }
}
