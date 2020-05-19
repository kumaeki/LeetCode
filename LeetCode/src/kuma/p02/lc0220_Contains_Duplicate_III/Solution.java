package kuma.p02.lc0220_Contains_Duplicate_III;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

public class Solution {
    // Runtime: 19 ms, faster than 37.40% of Java online submissions for Contains
    // Duplicate III.
    // Memory Usage: 40.8 MB, less than 6.82% of Java online submissions for
    // Contains Duplicate III.
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 1 || t < 0)
            return false;
        TreeSet<Long> tree = new TreeSet<Long>();
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            Long pre = tree.floor(num), next = tree.ceiling(num);
            if ((pre != null && num - pre <= t) || (next != null && next - num <= t))
                return true;
            tree.add(num);
            if (i >= k)
                tree.remove((long) nums[i - k]);
        }
        return false;
    }

    @Test
    public void simple1() {
        assertEquals(true, new Solution().containsNearbyAlmostDuplicate(new int[] { 3, 6, 0, 2 }, 2, 2));
    }

    @Test
    public void simple2() {
        assertEquals(false, new Solution().containsNearbyAlmostDuplicate(new int[] { -1, Integer.MAX_VALUE }, 1,
                Integer.MAX_VALUE));
    }

    @Test
    public void simple3() {
        assertEquals(false,
                new Solution().containsNearbyAlmostDuplicate(new int[] { 0, 10, 22, 15, 0, 5, 22, 12, 1, 5 }, 3, 3));
    }
}
