package kuma.lc1362_Closest_Divisors;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MyTest {
    @Test
    public void testSimple1() {
        assertArrayEquals(new int[] { 3, 3, }, new Solution().closestDivisors(8));
    }

    @Test
    public void testSimple2() {
        assertArrayEquals(new int[] { 5, 25 }, new Solution().closestDivisors(123));
    }

    @Test
    public void testSimple3() {
        assertArrayEquals(new int[] { 25, 40 }, new Solution().closestDivisors(999));
    }
    
    @Test
    public void testSimple4() {
        assertArrayEquals(new int[] { 1, 1 }, new Solution().closestDivisors(0));
    }
}
