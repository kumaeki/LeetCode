package kuma.p01.lc0155_Min_Stack;

import java.util.*;

class MinStack3 {

    Stack<Integer> stack;
    List<Integer> list;

    /** initialize your data structure here. */
    public MinStack3() {
        stack = new Stack<Integer>();
        list = new ArrayList<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        int index = getIndex(list, x);
        list.add(index, x);
    }

    public void pop() {
        int val = stack.pop();
        int index = getIndex(list, val);
        list.remove(index);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return list.get(0);
    }

    private int getIndex(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) > target) {
                right = mid - 1;
            } else if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

}
