package kuma.p00.lc0051_N_Queens_II;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Solution2 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for N-Queens
    // II.
    // Memory Usage: 35.7 MB, less than 8.70% of Java online submissions for
    // N-Queens II.
    public int totalNQueens(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = i;

        return helper(0, nums, new boolean[n], new int[2 * n - 1], new int[2 * n - 1]);
    }

    private int helper(int row, int[] nums, boolean[] visited, int[] set1, int[] set2) {
        if (row == nums.length) {
            return 1;
        } else {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                if (visited[i])
                    continue;
                int slope1 = nums[i] - row + nums.length - 1, slope2 = row + nums[i];
                if (set1[slope1] == 0 && set2[slope2] == 0) {
                    set1[slope1] = 1;
                    set2[slope2] = 1;
                    visited[i] = true;
                    res += helper(row + 1, nums, visited, set1, set2);
                    visited[i] = false;
                    set1[slope1] = 0;
                    set2[slope2] = 0;
                }

            }
            return res;
        }
    }

    @Test
    public void simple1() {
        assertEquals(2, new Solution2().totalNQueens(4));
    }

    @Test
    public void simple2() {
        assertEquals(352, new Solution2().totalNQueens(9));
    }
}
