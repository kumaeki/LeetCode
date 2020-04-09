package kuma.p07.lc0719_Find_Kth_Smallest_Pair_Distance;

import java.util.*;

class Solution3 {
    // Runtime: 3 ms, faster than 100.00% of Java online submissions for Find K-th
    // Smallest Pair Distance.
    // Memory Usage: 39.9 MB, less than 81.25% of Java online submissions for Find
    // K-th Smallest Pair Distance.
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;

        int left = 0, right = nums[len - 1] - nums[0];
        while (left < right) {
            int mid = (left + right) / 2, count = 0, i = 0;
            for (int j = 1; j < len; j++) {
                while (nums[j] - nums[i] > mid)
                    i++;
                count += (j - i);
            }

            if (count < k)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
