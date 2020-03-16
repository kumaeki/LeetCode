package kuma.lc1383_Maximum_Performance_of_a_Team;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class MyTest {
    @Test
    public void Simple1() {
        int expected = 60;
        int n = 6, k = 2;
        int[] speed = new int[] { 2, 10, 3, 1, 5, 8 }, efficiency = new int[] { 5, 4, 3, 9, 7, 2 };
        int actual = new Solution().maxPerformance(n, speed, efficiency, k);
        assertEquals(expected, actual);
    }

    @Test
    public void Simple2() {
        int expected = 68;
        int n = 6, k = 3;
        int[] speed = new int[] { 2, 10, 3, 1, 5, 8 }, efficiency = new int[] { 5, 4, 3, 9, 7, 2 };
        int actual = new Solution().maxPerformance(n, speed, efficiency, k);
        assertEquals(expected, actual);
    }

    @Test
    public void Simple3() {
        int expected = 72;
        int n = 6, k = 4;
        int[] speed = new int[] { 2, 10, 3, 1, 5, 8 }, efficiency = new int[] { 5, 4, 3, 9, 7, 2 };
        int actual = new Solution().maxPerformance(n, speed, efficiency, k);
        assertEquals(expected, actual);
    }
}
