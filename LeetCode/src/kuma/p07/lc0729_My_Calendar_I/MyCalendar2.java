package kuma.p07.lc0729_My_Calendar_I;

import java.util.*;

class MyCalendar2 {
    // Runtime: 16 ms, faster than 96.28% of Java online submissions for My Calendar
    // I.
    // Memory Usage: 40.4 MB, less than 100.00% of Java online submissions for My
    // Calendar I.
    List<Integer> listL, listR;

    public MyCalendar2() {
        listL = new ArrayList<Integer>();
        listR = new ArrayList<Integer>();
    }

    public boolean book(int start, int end) {
        if (listL.isEmpty()) {
            listL.add(start);
            listR.add(end);
            return true;
        } else {
            int index = Collections.binarySearch(listL, start);
            if (index >= 0)
                return false;
            else {
                index = -(index + 1);
                if ((index > 0 && listR.get(index - 1) > start) || (index < listL.size() && end > listL.get(index)))
                    return false;
                listL.add(index, start);
                listR.add(index, end);
                return true;
            }
        }
    }

    public static void main(String[] args) {
        MyCalendar2 obj = new MyCalendar2();
        obj.book(47, 50);
        obj.book(33, 41);
        obj.book(39, 45);
        obj.book(33, 42);
    }
}
