package kuma.p07.lc0729_My_Calendar_I;

import java.util.*;

class MyCalendar {
    // Runtime: 23 ms, faster than 63.94% of Java online submissions for My Calendar
    // I.
    // Memory Usage: 40.6 MB, less than 100.00% of Java online submissions for My
    // Calendar I.
    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<Integer, Integer>();
    }

    public boolean book(int start, int end) {
        Integer pre = map.floorKey(start), next = map.ceilingKey(start);
        if ((pre == null || map.get(pre) <= start) && (next == null || end <= next)) {
            map.put(start, end);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyCalendar obj = new MyCalendar();
        obj.book(47, 50);
        obj.book(33, 41);
        obj.book(39, 45);
        obj.book(33, 42);
    }
}
