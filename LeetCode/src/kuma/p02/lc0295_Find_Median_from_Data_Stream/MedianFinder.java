package kuma.p02.lc0295_Find_Median_from_Data_Stream;

import java.util.*;

class MedianFinder {

    PriorityQueue<Integer> small, large;

    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<Integer>(Collections.reverseOrder());
        large = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {

        if (small.isEmpty())
            small.offer(num);
        else {
            if (num > small.peek())
                large.offer(num);
            else
                small.offer(num);
        }

        if (small.size() - 1 > large.size())
            large.offer(small.poll());
        else if (small.size() < large.size())
            small.offer(large.poll());
    }

    public double findMedian() {
        if (small.size() == large.size())
            return (small.peek() + large.peek()) / 2.0;
        else
            return small.peek();
    }
}