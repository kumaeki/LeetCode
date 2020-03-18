package kuma.p02.lc0234_Palindrome_Linked_List;

import java.util.*;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int left = 0, right = list.size() - 1;
        while (left < right) {
            if (list.get(left++).val != list.get(right--).val)
                return false;
        }
        return true;
    }
}
