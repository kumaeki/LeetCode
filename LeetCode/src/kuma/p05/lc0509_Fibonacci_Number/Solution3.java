package kuma.p05.lc0509_Fibonacci_Number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution3 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Fibonacci
    // Number. 
    // Memory Usage: 35.8 MB, less than 5.51% of Java online submissions for
    // Fibonacci Number.

    static int[][] base = new int[][] { { 1, 1 }, { 1, 0 } };

    public int fib(int N) {
        if (N < 2)
            return N;
        int[][] m = new int[][] { { 1, 1 }, { 1, 0 } };
        helper(m, N - 1);
        return m[0][0];
    }

    private void helper(int[][] m, int n) {
        if (n > 1) {
            helper(m, n / 2);
            mmult(m, m);
            if ((n & 1) == 1)
                mmult(m, base);
        }
    }

    private void mmult(int[][] m1, int[][] m2) {
        int a = m1[0][0] * m2[0][0] + m1[0][1] * m2[1][0];
        int b = m1[0][0] * m2[0][1] + m1[0][1] * m2[1][1];
        int c = m1[1][0] * m2[0][0] + m1[1][1] * m2[1][0];
        int d = m1[1][0] * m2[0][1] + m1[1][1] * m2[1][1];
        m1[0][0] = a;
        m1[0][1] = b;
        m1[1][0] = c;
        m1[1][1] = d;
    }

    @Test
    public void simple1() {
        assertEquals(1, new Solution().fib(2));
    }

    @Test
    public void simple2() {
        assertEquals(3, new Solution().fib(4));
    }

    @Test
    public void simple3() {
        assertEquals(832040, new Solution().fib(30));
    }
}
