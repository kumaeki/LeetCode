package kuma.p06.lc0665_Non_decreasing_Array;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class Solution {
    // Runtime: 2 ms, faster than 8.64% of Java online submissions for
    // Non-decreasing Array.
    // Memory Usage: 51.6 MB, less than 9.52% of Java online submissions for
    // Non-decreasing Array.
    public boolean checkPossibility(int[] nums) {
        int index = 0, len = nums.length;
        while (index < len - 1)
            if (nums[index] > nums[index + 1])
                break;
            else
                index++;

        return index == len - 1 || changeLeft(nums, index) || changeRight(nums, index);
    }

    private boolean changeLeft(int[] nums, int index) {
        if (index > 0 && nums[index - 1] > nums[index + 1])
            return false;
        for (int i = index + 1; i < nums.length - 1; i++)
            if (nums[i] > nums[i + 1])
                return false;
        return true;
    }

    private boolean changeRight(int[] nums, int index) {
        nums[index + 1] = nums[index];
        for (int i = index + 1; i < nums.length - 1; i++)
            if (nums[i] > nums[i + 1])
                return false;
        return true;
    }

    @Test
    public void simple1() {
        assertEquals(true, new Solution().checkPossibility(new int[] { 2, 3, 3, 2, 4 }));
    }
}
