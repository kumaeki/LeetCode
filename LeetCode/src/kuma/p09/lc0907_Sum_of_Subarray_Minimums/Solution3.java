package kuma.p09.lc0907_Sum_of_Subarray_Minimums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Stack;

class Solution3 {
    // Runtime: 22 ms, faster than 70.41% of Java online submissions for Sum of
    // Subarray Minimums.
    // Memory Usage: 46.4 MB, less than 55.56% of Java online submissions for Sum of
    // Subarray Minimums..
    public int sumSubarrayMins(int[] A) {
        int n = A.length, res = A[0];
        int[] dp = new int[n];
        dp[0] = A[0];
        Stack<Integer> s = new Stack<Integer>();
        s.add(0);
        for (int i = 1; i < n; i++) {
            while (!s.isEmpty() && A[s.peek()] >= A[i])
                s.pop();
            if (s.isEmpty())
                dp[i] = (i + 1) * A[i];
            else
                dp[i] = (i - s.peek()) * A[i] + dp[s.peek()];
            s.push(i);
            res += dp[i];
            res %= 1_000_000_007;
        }
        return res;
    }

    @org.junit.jupiter.api.Test
    public void simple1() {
        assertEquals(209, new Solution3().sumSubarrayMins(new int[] { 59, 91 }));
    }
}
