package kuma.p05.lc0532_K_diff_Pairs_in_an_Array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.Test;

public class Solution2 {
    // Runtime: 5 ms, faster than 95.04% of Java online submissions for K-diff Pairs
    // in an Array.
    // Memory Usage: 39.5 MB, less than 94.74% of Java online submissions for
    // K-diff Pairs in an Array.

    public int findPairs(int[] nums, int k) {
        if (k < 0 || nums.length < 2)
            return 0;

        int res = 0, left = 0, right = 1;
        int i, j;
        Arrays.parallelSort(nums);
        while (right < nums.length) {
            i = nums[left];
            j = nums[right];
            if (j - i < k)
                right++;
            else if (j - i > k)
                left++;
            else {
                res++;
                while (left < nums.length && nums[left] == i)
                    left++;
                while (right < nums.length && nums[right] == j)
                    right++;

            }
            if (left == right)
                right++;
        }
        return res;
    }

    @Test
    public void simple1() {
        assertEquals(2, new Solution2().findPairs(new int[] { -1, -2, -3 }, 1));
    }
}
