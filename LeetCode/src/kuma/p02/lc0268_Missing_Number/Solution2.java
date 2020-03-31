package kuma.p02.lc0268_Missing_Number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution2 {
    // Runtime: 1 ms, faster than 37.47% of Java online submissions for Missing
    // Number.
    // Memory Usage: 40.3 MB, less than 98.95% of Java online submissions for
    // Missing Number.
    public int missingNumber(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int left, int right) {
        if (left > right)
            return left;
        int i = left, j = right + 1, val = nums[left];
        while (true) {
            while (i < j - 1 && nums[++i] < val)
                if (i == right)
                    break;
            while (nums[--j] > val)
                if (j == left)
                    break;
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, left, j);
        if (j == nums[j])
            return helper(nums, j + 1, right);
        else
            return helper(nums, left, j - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void simple1() {
        assertEquals(0, new Solution2().missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 8, 1 }));
    }

    @Test
    public void simple2() {
        assertEquals(8, new Solution2().missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));
    }

    @Test
    public void simple3() {
        assertEquals(2, new Solution2().missingNumber(new int[] { 3, 0, 1 }));
    }

    @Test
    public void simple4() {
        assertEquals(0, new Solution2().missingNumber(new int[] { 1 }));
    }

    @Test
    public void simple5() {
        assertEquals(1, new Solution2().missingNumber(new int[] { 0 }));
    }
}
