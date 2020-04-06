package kuma.p06.lc0665_Non_decreasing_Array;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class Solution2 {
    // Runtime: 1 ms, faster than 80.60% of Java online submissions for
    // Non-decreasing Array.
    // Memory Usage: 51.8 MB, less than 9.52% of Java online submissions for
    // Non-decreasing Array.
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] > nums[i + 1]) {
                if (count++ > 0)
                    return false;
                if (i > 0 && nums[i - 1] > nums[i + 1])
                    nums[i + 1] = nums[i];
                else
                    nums[i] = nums[i + 1];
            }
        return true;
    }

    @Test
    public void simple1() {
        assertEquals(true, new Solution2().checkPossibility(new int[] { 2, 3, 3, 2, 4 }));
    }
}
