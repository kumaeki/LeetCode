package kuma.p01.lc0155_Min_Stack;

class MinStack {

    Node cur;

    /** initialize your data structure here. */
    public MinStack() {
        cur = null;
    }

    public void push(int x) {
        if (cur == null) {
            cur = new Node(x, x);
        } else {
            Node node = new Node(x, Math.min(x, cur.min));
            node.pre = cur;
            cur = node;
        }
    }

    public void pop() {
        cur = cur.pre;
    }

    public int top() {
        return cur.val;
    }

    public int getMin() {
        return cur.min;
    }

    class Node {
        int val;
        int min;
        Node pre;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
            pre = null;
        }
    }

}
