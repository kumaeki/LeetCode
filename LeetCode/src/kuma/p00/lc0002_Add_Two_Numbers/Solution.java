package kuma.p00.lc0002_Add_Two_Numbers;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return sum(l1, l2, 0);
    }

    private ListNode sum(ListNode l1, ListNode l2, int t) {
        if (l1 == null && t == 0)
            return l2;
        if (l2 == null && t == 0)
            return l1;

        int sum = t;
        ListNode next1 = null, next2 = null;
        if (l1 != null) {
            sum += l1.val;
            next1 = l1.next;
        }
        if (l2 != null) {
            sum += l2.val;
            next2 = l2.next;
        }

        ListNode node = new ListNode(sum % 10);
        node.next = sum(next1, next2, sum / 10);
        return node;
    }

    @Test
    public void testSimple1() {
        ListNode expected = createList(new int[] { 7, 0, 8 });
        ListNode l1 = createList(new int[] { 2, 4, 3 });
        ListNode l2 = createList(new int[] { 5, 6, 4 });
        ListNode actuals = new Solution().addTwoNumbers(l1, l2);
        assertTrue(isEquals(expected, actuals));

    }

    @Test
    public void testSimple2() {
        ListNode expected = createList(new int[] { 0 });
        ListNode l1 = createList(new int[] { 0 });
        ListNode l2 = createList(new int[] { 0 });
        ListNode actuals = new Solution().addTwoNumbers(l1, l2);
        assertTrue(isEquals(expected, actuals));

    }

    @Test
    public void testSimple3() {
        ListNode expected = createList(new int[] { 4, 2, 6, 3 });
        ListNode l1 = createList(new int[] { 1, 0, 2, 3 });
        ListNode l2 = createList(new int[] { 3, 2, 4 });
        ListNode actuals = new Solution().addTwoNumbers(l1, l2);
        assertTrue(isEquals(expected, actuals));

    }

    @Test
    public void testSimple4() {
        ListNode expected = createList(new int[] { 4, 0, 3, 1 });
        ListNode l1 = createList(new int[] { 1, 0, 9 });
        ListNode l2 = createList(new int[] { 3, 0, 4 });
        ListNode actuals = new Solution().addTwoNumbers(l1, l2);
        assertTrue(isEquals(expected, actuals));

    }

    public static ListNode createList(int[] list) {
        ListNode head = new ListNode(list[0]);
        ListNode pre = head;
        for (int i = 1; i < list.length; i++) {
            ListNode node = new ListNode(list[i]);
            pre.next = node;
            pre = node;
        }
        return head;
    }

    public boolean isEquals(ListNode expected, ListNode actuals) {
        while (expected != null && actuals != null) {
            if (expected.val != actuals.val)
                return false;
            expected = expected.next;
            actuals = actuals.next;
        }
        if (expected == null && actuals == null)
            return true;
        else
            return false;
    }
}
