package kuma.p01.lc0155_Min_Stack;

import java.util.*;

class MinStack2 {

    Stack<Integer> stack;
    List<Integer> list;

    /** initialize your data structure here. */
    public MinStack2() {
        stack = new Stack<Integer>();
        list = new ArrayList<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        for (int i = 0; i < list.size(); i++)
            if (list.get(i) > x) {
                list.add(i, x);
                return;
            }
        list.add(list.size(), x);
    }

    public void pop() {
        int val = stack.pop();
        for (int i = 0; i < list.size(); i++)
            if (list.get(i) == val) {
                list.remove(i);
                return;
            }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return list.get(0);
    }

}
