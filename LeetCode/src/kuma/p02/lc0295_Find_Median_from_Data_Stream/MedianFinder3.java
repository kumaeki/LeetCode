package kuma.p02.lc0295_Find_Median_from_Data_Stream;

import java.util.*;

public class MedianFinder3 {

    List<Integer> list;

    /** initialize your data structure here. */
    public MedianFinder3() {
        list = new ArrayList<Integer>();
    }

    public void addNum(int num) {
        int index = Collections.binarySearch(list, num);
        if (index >= 0)
            list.add(index, num);
        else
            list.add(-(index + 1), num);
    }

    public double findMedian() {
        if (list.size() % 2 == 0) {
            return (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2.0;
        } else
            return list.get(list.size() / 2);
    }
}
