package kuma.lc0138_Copy_List_with_Random_Pointer;

public class Solution {
    public Node copyRandomList(Node head) {
        // round 1, copy node
        Node old = head;
        while (old != null) {
            Node nw = new Node(old.val);
            nw.next = old.next;
            old.next = nw;
            old = old.next.next;
        }

        // round 2, set the random
        old = head;
        while (old != null) {
            if (old.random != null) {
                old.next.random = old.random.next;
            }
            old = old.next.next;
        }

        // round 3, get the new list
        Node headn = new Node(-1);
        Node nw = headn;
        old = head;
        while (old != null) {
            nw.next = old.next;
            old.next = old.next.next;
            nw = nw.next;
            old = old.next;
        }
        return headn.next;
    }
}
