package kuma.p00.lc0002_Add_Two_Numbers;

public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(), node = head;
        int t = 0;
        while (l1 != null || l2 != null || t != 0) {
            int sum = t;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            node.next = new ListNode(sum % 10);
            node = node.next;
            t = sum / 10;
        }
        return head.next;
    }
}
