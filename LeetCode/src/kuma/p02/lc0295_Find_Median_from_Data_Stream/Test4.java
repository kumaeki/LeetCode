package kuma.p02.lc0295_Find_Median_from_Data_Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Test4 {

    @Test
    public void simple1() {
        MedianFinder4 obj = new MedianFinder4();
        obj.addNum(1);
        obj.addNum(2);
        assertEquals(1.5, obj.findMedian());
        obj.addNum(3);
        assertEquals(2, obj.findMedian());

    }
}
