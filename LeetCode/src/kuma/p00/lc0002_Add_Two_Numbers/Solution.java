package kuma.p00.lc0002_Add_Two_Numbers;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.next == null && l1.val == 0)
            return l2;
        if (l2.next == null && l2.val == 0)
            return l1;

        return helper(l1, l2, 0);
    }

    private ListNode helper(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0)
            return null;

        int res = carry;
        int nextCarry = 0;
        ListNode nextl1 = null;
        ListNode nextl2 = null;
        if (l1 != null) {
            res += l1.val;
            nextl1 = l1.next;
        }
        if (l2 != null) {
            res += l2.val;
            nextl2 = l2.next;
        }
        if (res >= 10) {
            nextCarry = 1;
            res %= 10;
        }
        ListNode node = new ListNode(res);
        node.next = helper(nextl1, nextl2, nextCarry);
        return node;
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
}
