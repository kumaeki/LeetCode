package kuma.p09.lc0907_Sum_of_Subarray_Minimums;

import java.util.Stack;

class Solution2 {
    // Runtime: 34 ms, faster than 37.66% of Java online submissions for Sum of
    // Subarray Minimums.
    // Memory Usage: 45.9 MB, less than 55.56% of Java online submissions for Sum of
    // Subarray Minimums.
    public int sumSubarrayMins(int[] A) {
        int n = A.length, res = 0;
        int[] left = new int[n], right = new int[n];
        Stack<Integer> s1 = new Stack<Integer>(), s2 = new Stack<Integer>();

        for (int i = 0; i < n; i++) {
            while (!s1.isEmpty() && A[s1.peek()] >= A[i])
                s1.pop();
            left[i] = s1.isEmpty() ? -1 : s1.peek();
            s1.push(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!s2.isEmpty() && A[s2.peek()] > A[i])
                s2.pop();
            right[i] = s2.isEmpty() ? n : s2.peek();
            s2.push(i);
        }

        for (int i = 0; i < n; i++) {
            res += (right[i] - i) * (i - left[i]) * A[i];
            res %= 1_000_000_007;
        }
        return res;
    }
}
