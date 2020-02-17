package kuma.lc141_Linked_List_Cycle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Solution {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }

        return false;
    }

    public static ListNode createList(int[] list, int index) {
        ListNode head = new ListNode(list[0]);
        ListNode pre = head;
        ListNode entrance = null;
        for (int i = 1; i < list.length; i++) {
            ListNode node = new ListNode(list[i]);
            pre.next = node;
            pre = node;

            if (i == index)
                entrance = node;
        }
        if (index == 0)
            entrance = head;

        if (index >= 0)
            pre.next = entrance;

        return head;
    }

    @Test
    public void TestSimple1() {
        int[] list = new int[] { 3, 2, 0, -4 };
        int index = 2;
        ListNode head = createList(list, index);
        assertEquals(true, new Solution().hasCycle(head));
    }

    @Test
    public void TestSimple2() {
        int[] list = new int[] { 1, 2 };
        int index = 0;
        ListNode head = createList(list, index);
        assertEquals(true, new Solution().hasCycle(head));
    }

    @Test
    public void TestSimple3() {
        int[] list = new int[] { 1 };
        int index = -1;
        ListNode head = createList(list, index);
        assertEquals(false, new Solution().hasCycle(head));
    }
}
