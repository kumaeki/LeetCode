package kuma.p09.lc0945_Minimum_Increment_to_Make_Array_Unique;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class Solution {
    // Runtime: 21 ms, faster than 27.77% of Java online submissions for Minimum
    // Increment to Make Array Unique.
    // Memory Usage: 54 MB, less than 16.67% of Java online submissions for Minimum
    // Increment to Make Array Unique.
    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length < 2)
            return 0;
        Arrays.sort(A);

        int len = A.length, res = 0, index = 1, pre = A[0], cur;
        while (index < len) {
            cur = A[index++];
            if (cur > pre) {
                pre = cur;
            } else {
                res += (pre - cur + 1);
                pre++;
            }
        }
        return res;
    }

    @Test
    public void simple1() {
        assertEquals(6, new Solution().minIncrementForUnique(new int[] { 1, 1, 2, 2, 3, 7 }));
    }
}
