package kuma.p00.lc0016_3Sum_Closest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

public class Solution2 {
    // Runtime: 3 ms, faster than 98.44% of Java online submissions for 3Sum
    // Closest.
    // Memory Usage: 39.6 MB, less than 6.67% of Java online submissions for 3Sum
    // Closest.

    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length, res = target, min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            int a = target - nums[i], sum = nums[left] + nums[right];
            while (left < right) {
                sum = nums[left] + nums[right];
                int dif = Math.abs(a - sum);
                if (dif < min) {
                    min = dif;
                    res = sum + nums[i];
                }
                if (sum > a)
                    right--;
                else if (sum < a)
                    left++;
                else
                    return target;
            }
        }
        return res;
    }

    @Test
    public void simple1() {
        assertEquals(2, new Solution2().threeSumClosest(new int[] { -4, -1, 1, 2 }, 1));
    }

    @Test
    public void simple2() {
        assertEquals(13, new Solution2().threeSumClosest(new int[] { 1, 2, 5, 10, 11 }, 12));
    }
}
