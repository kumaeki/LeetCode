package kuma.p05.lc0509_Fibonacci_Number;

public class Solution2 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Fibonacci
    // Number.
    // Memory Usage: 36.4 MB, less than 5.51% of Java online submissions for
    // Fibonacci Number.

    public int fib(int N) {
        if (N < 1)
            return N;

        int pre = 0, cur = 1, next = 1;
        for (int i = 2; i < N; i++) {
            next = pre + cur;
            cur = next;
            pre = cur;
        }
        return next;
    }
}
