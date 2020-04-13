package kuma.p07.lc0795_Number_of_Subarrays_with_Bounded_Maximum;

public class Solution2 {
    // Runtime: 2 ms, faster than 100.00% of Java online submissions for Number of
    // Subarrays with Bounded Maximum.
    // Memory Usage: 47.7 MB, less than 100.00% of Java online submissions for
    // Number of Subarrays with Bounded Maximum.
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int left = 0, right = -1, count = 0;
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            if (a <= R) {
                if (a >= L)
                    right = i;
                if (right >= left)
                    count += (right - left + 1);
            } else if (i < A.length - 1 && a > R) {
                left = i + 1;
            }
        }
        return count;
    }
}
