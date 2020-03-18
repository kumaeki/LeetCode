package kuma.p13.lc1360_Number_of_Days_Between_Two_Dates;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class MyTest {
    @Test
    public void testSimple1() {
        assertEquals(15, new Solution().daysBetweenDates("2020-01-15", "2019-12-31"));
    }
}
