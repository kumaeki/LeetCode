package kuma.p02.lc0287_Find_the_Duplicate_Number;

import java.util.*;

public class Solution {

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Find the
    // Duplicate Number.
    // Memory Usage: 39.9 MB, less than 5.09% of Java online submissions for Find
    // the Duplicate Number.
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);

        int start = 0;
        while (start != slow) {
            start = nums[start];
            slow = nums[slow];
        }

        return start;
    }

    // set
    public int findDuplicate1(int[] nums) {
        Set<Integer> s = new HashSet<Integer>();
        for (int num : nums)
            if (!s.add(num))
                return num;
        return 0;
    }

    // sort the array
    public int findDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++)
            if (nums[i] == nums[i - 1])
                return nums[i];
        return 0;
    }
}
