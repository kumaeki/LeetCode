package kuma.p00.lc0025_Reverse_Nodes_in_k_Group;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

import kuma.common.ListNode;

public class Solution3 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse
    // Nodes in k-Group.
    // Memory Usage: 39.5 MB, less than 8.62% of Java online submissions for Reverse
    // Nodes in k-Group.
    public ListNode reverseKGroup(ListNode head, int k) {

        int count = 0;
        ListNode cur = head;
        while (cur != null && ++count < k) {
            cur = cur.next;
        }
        if (count < k)
            return head;

        cur.next = reverseKGroup(cur.next, k);
        ;
        while (head != cur) {
            ListNode temp = head.next;
            head.next = cur.next;
            cur.next = head;

            head = temp;
        }
        return head;
    }

    @Test
    public void simple1() {
        int[] list = new int[] { 1, 2, 3, 4, 5 };
        int k = 2;
        int[] actual = ListNode.getArr(new Solution3().reverseKGroup(ListNode.getList(list), k));
        // Arrays.stream(actual).forEach(x -> System.out.println(x));
        assertArrayEquals(new int[] { 2, 1, 4, 3, 5 }, actual);
    }

    @Test
    public void simple2() {
        assertArrayEquals(new int[] { 2, 1, 4, 3 },
                ListNode.getArr(new Solution3().reverseKGroup(ListNode.getList(new int[] { 1, 2, 3, 4 }), 2)));
    }

    @Test
    public void simple3() {
        assertArrayEquals(new int[] { 1, 2, 3, 4 },
                ListNode.getArr(new Solution3().reverseKGroup(ListNode.getList(new int[] { 1, 2, 3, 4 }), 1)));
    }

    @Test
    public void simple4() {
        assertArrayEquals(new int[] { 2, 1 },
                ListNode.getArr(new Solution3().reverseKGroup(ListNode.getList(new int[] { 1, 2 }), 2)));
    }
}
