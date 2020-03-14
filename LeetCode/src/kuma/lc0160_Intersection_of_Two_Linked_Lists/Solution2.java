package kuma.lc0160_Intersection_of_Two_Linked_Lists;

public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        boolean flga = true, flgb = true;
        while (true) {
            if (a == null || b == null)
                return null;
            if (a == b)
                return a;
            a = a.next;
            b = b.next;
            if (a == null && flga) {
                a = headB;
                flga = false;
            }
            if (b == null && flgb) {
                b = headA;
                flgb = false;
            }
        }
    }
}