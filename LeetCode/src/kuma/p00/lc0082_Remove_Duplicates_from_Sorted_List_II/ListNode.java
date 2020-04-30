package kuma.p00.lc0082_Remove_Duplicates_from_Sorted_List_II;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode getList(int[] arr) {
        ListNode pre = new ListNode(-1), head = pre;

        for (int a : arr) {
            ListNode node = new ListNode(a);
            head.next = node;
            head = node;
        }
        return pre.next;
    }

    public static int[] getArr(ListNode node) {
        List<Integer> list = new ArrayList<Integer>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }
}
