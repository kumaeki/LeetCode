package kuma.p07.lc0719_Find_Kth_Smallest_Pair_Distance;

import java.util.*;

class Solution2 {
    // Runtime: 16 ms, faster than 38.35% of Java online submissions for Find K-th
    // Smallest Pair Distance.
    // Memory Usage: 47.4 MB, less than 6.25% of Java online submissions for Find
    // K-th Smallest Pair Distance.
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.parallelSort(nums);
        int len = nums.length, size = 2 * nums[len - 1];

        int[] mul = new int[len];
        for (int i = 1; i < len; i++)
            if (nums[i] == nums[i - 1])
                mul[i] = mul[i - 1] + 1;

        int[] prefix = new int[size];
        int i = 0;
        for (int val = 0; val < size; val++) {
            while (i < len && nums[i] == val)
                i++;
            prefix[val] = i;
        }

        int left = 0, right = nums[len - 1] - nums[0];
        while (left < right) {
            int mid = (left + right) / 2, count = 0;
            for (int j = 0; j < len; j++)
                count += (prefix[nums[j] + mid] - prefix[nums[j]] + mul[j]);

            if (count < k)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
