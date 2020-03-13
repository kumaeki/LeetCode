package kuma.lc0155_Min_Stack;

import java.util.*;

class MinStack4 {

    Node cur;
    List<Node> list;
    Map<Node, Integer> map;

    /** initialize your data structure here. */
    public MinStack4() {
        cur = null;
        list = new ArrayList<Node>();
        map = new HashMap<Node, Integer>();
    }

    public void push(int x) {
        if (cur == null) {
            cur = new Node(x);
            list.add(cur);
            map.put(cur, 0);
        } else {
            Node node = new Node(x);
            node.pre = cur;
            cur = node;

            int index = getIndex(list, cur);
            list.add(index, cur);
            map.put(cur, index);
        }
    }

    public void pop() {
        list.remove(map.get(cur).intValue());
        map.remove(cur);
        cur = cur.pre;
    }

    public int top() {
        return cur.val;
    }

    public int getMin() {
        return list.get(0).val;
    }

    private int getIndex(List<Node> list, Node node) {
        int left = 0, right = list.size() - 1;
        int target = node.val;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid).val > target) {
                right = mid - 1;
            } else if (list.get(mid).val < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    class Node {
        int val;
        Node pre;

        public Node(int value) {
            val = value;
            pre = null;
        }
    }

}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */
