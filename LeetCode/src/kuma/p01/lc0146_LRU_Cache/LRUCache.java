package kuma.p01.lc0146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    ListNode head;
    ListNode tail;
    Map<Integer, ListNode> map;
    int cap;

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<Integer, ListNode>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            ListNode node = map.get(key);
            if (node != head) {
                if (node != tail) {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                } else {
                    node.pre.next = null;
                    tail = node.pre;
                }
                head.pre = node;
                node.next = head;
                head = node;
            }

            return head.val;
        }
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;
            map.put(key, node);
            if (node != head) {
                if (node != tail) {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                } else {
                    node.pre.next = null;
                    tail = node.pre;
                }
                head.pre = node;
                node.next = head;
                head = node;
            }
        } else {
            ListNode node = new ListNode(key, value);
            map.put(key, node);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                head.pre = node;
                node.next = head;
                head = node;
            }
            if (map.size() > cap) {
                map.remove(tail.key);
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    tail.pre.next = null;
                    tail = tail.pre;
                }

            }
        }

    }

    class ListNode {

        int key;
        int val;
        ListNode pre;
        ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

    }

}
