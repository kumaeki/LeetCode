package kuma.p05.lc0532_K_diff_Pairs_in_an_Array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.Test;

public class Solution {
    // Runtime: 5 ms, faster than 95.04% of Java online submissions for K-diff Pairs
    // in an Array.
    // Memory Usage: 39.7 MB, less than 89.47% of Java online submissions for K-diff
    // Pairs in an Array.

    public int findPairs(int[] nums, int k) {
        if (k < 0 || nums.length == 0)
            return 0;

        int res = 0;
        if (k == 0) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                if (map.get(num) == 2)
                    res++;
            }
            return res;
        }
        Arrays.sort(nums);
        int target;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && Integer.MAX_VALUE - nums[i] < k)
                break;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            } else {
                target = nums[i] + k;
                if (Arrays.binarySearch(nums, target) >= 0)
                    res++;
            }
        }
        return res;
    }

    @Test
    public void simple1() {
        assertEquals(2, new Solution().findPairs(new int[] { -1, -2, -3 }, 1));
    }
}
