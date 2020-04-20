package kuma.p09.lc0962_Maximum_Width_Ramp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Stack;

import org.junit.jupiter.api.Test;

class Solution4 {
    // Runtime: 7 ms, faster than 82.17% of Java online submissions for Maximum
    // Width Ramp.
    // Memory Usage: 47.4 MB, less than 100.00% of Java online submissions for
    // Maximum Width Ramp.
    public int maxWidthRamp(int[] A) {
        int n = A.length, res = 0;
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < n; i++)
            if (s.isEmpty() || A[s.peek()] > A[i])
                s.push(i);
        for (int i = n - 1; i > res; i--)
            while (!s.isEmpty() && A[s.peek()] <= A[i])
                res = Math.max(res, i - s.pop());
        return res;
    }

    @Test
    public void simple1() {
        assertEquals(1, new Solution4().maxWidthRamp(new int[] { 1, 1 }));
    }

    @Test
    public void simple2() {
        assertEquals(0, new Solution4().maxWidthRamp(new int[] { 4, 3, 2, 1 }));
    }

    @Test
    public void simple3() {
        assertEquals(3, new Solution4().maxWidthRamp(new int[] { 9, 1, 1, 9 }));
    }
}
