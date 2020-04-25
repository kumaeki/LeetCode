package kuma.common;

import java.util.*;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
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
