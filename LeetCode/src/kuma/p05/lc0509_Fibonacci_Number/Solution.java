package kuma.p05.lc0509_Fibonacci_Number;

import java.util.*;

public class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Fibonacci
    // Number.
    // Memory Usage: 36.4 MB, less than 5.51% of Java online submissions for
    // Fibonacci Number.
    public static List<Integer> list;;
    {
        list = new ArrayList<Integer>(31);
        list.add(0);
        list.add(1);
        for (int i = 2; i <= 30; i++)
            list.add(list.get(i - 1) + list.get(i - 2));
    }

    public int fib(int N) {
        return list.get(N);
    }
}
