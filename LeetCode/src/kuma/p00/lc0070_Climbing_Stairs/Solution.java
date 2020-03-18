package kuma.p00.lc0070_Climbing_Stairs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.Test;

public class Solution {

    static List<Integer> list = new ArrayList<Integer>();

    static {
        list.add(1);
        list.add(1);
    }

    public int climbStairs(int n) {
        int len = list.size();
        if (n < len)
            return list.get(n);
        else {
            for (int k = len; k <= n; k++) {
                list.add(list.get(k - 1) + list.get(k - 2));
            }
        }
        return list.get(n);
    }

    @Test
    public void simple1() {
        int expected = 1;
        int actual = new Solution().climbStairs(1);
        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        int expected = 2;
        int actual = new Solution().climbStairs(2);
        assertEquals(expected, actual);
    }

    @Test
    public void simple3() {
        int expected = 3;
        int actual = new Solution().climbStairs(3);
        assertEquals(expected, actual);
    }

    @Test
    public void simple4() {
        int expected = 5;
        int actual = new Solution().climbStairs(4);
        assertEquals(expected, actual);
    }

}
