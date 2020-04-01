package kuma.p04.lc0442_Find_All_Duplicates_in_an_Array;

import static org.junit.Assert.assertArrayEquals;
import java.util.*;

import org.junit.Test;

public class Solution2 {
    // Runtime: 4 ms, faster than 97.60% of Java online submissions for Find All
    // Duplicates in an Array.
    // Memory Usage: 48.8 MB, less than 36.11% of Java online submissions for Find
    // All Duplicates in an Array.
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] < 0)
                res.add(num);
            else
                nums[num - 1] *= -1;
        }
        return res;
    }

    @Test
    public void simple1() {
        assertArrayEquals(new Integer[] { 2, 3 },
                new Solution2().findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }).toArray(new Integer[2]));
    }
}
