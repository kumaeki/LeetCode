package kuma.p01.lc0147_Insertion_Sort_List;

import java.util.*;

public class Solution3 {
    // Runtime: 5 ms, faster than 74.03% of Java online submissions for Insertion
    // Sort List.
    // Memory Usage: 40.1 MB, less than 5.13% of Java online submissions for
    // Insertion Sort List.
    public ListNode insertionSortList(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
        int index = 0;
        while (head != null) {
            map.put(index++, head);
            head = head.next;
        }
        Integer[] arr = new Integer[index];
        for (int i = 0; i < index; i++)
            arr[i] = i;
        Arrays.parallelSort(arr, (x, y) -> (map.get(x).val - map.get(y).val));
        ListNode fakeHead = new ListNode(Integer.MIN_VALUE), cur = fakeHead;
        for (int i = 0; i < index; i++) {
            cur.next = map.get(arr[i]);
            cur = cur.next;
        }
        cur.next = null;
        return fakeHead.next;
    }

}
