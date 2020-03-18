package kuma.p00.lc0041_First_Missing_Positive;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution2 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            while (i + 1 != nums[i]) {
                int index = nums[i] - 1;
                if (index < 0 || index >= len || index + 1 == nums[index]) {
                    nums[i] = 0;
                    break;
                } else
                    swap(nums, i, index);
            }
        }

        for (int i = 0; i < len; i++)
            if (nums[i] == 0)
                return i + 1;

        return len + 1;

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void testSimple1() {
        int expected = 3;
        int[] nums = new int[] { 1, 2, 0 };
        int actual = new Solution2().firstMissingPositive(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple2() {
        int expected = 2;
        int[] nums = new int[] { 3, 4, -1, 1 };
        int actual = new Solution2().firstMissingPositive(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple3() {
        int expected = 1;
        int[] nums = new int[] { 7, 8, 9, 11, 12 };
        int actual = new Solution2().firstMissingPositive(nums);
        assertEquals(expected, actual);
    }
}
