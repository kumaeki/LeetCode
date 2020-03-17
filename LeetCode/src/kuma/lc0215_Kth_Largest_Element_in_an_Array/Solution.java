package kuma.lc0215_Kth_Largest_Element_in_an_Array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, (left + right) / 2);
            int index = left;
            for (int i = left; i < right; i++)
                if (nums[i] >= nums[right])
                    swap(nums, i, index++);
            swap(nums, index, right);
            if (index < k - 1)
                left = index + 1;
            else if (index > k - 1)
                right = index - 1;
            else
                return nums[index];
        }
        return nums[left];
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j)
            return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void simple1() {
        int expected = 4;
        int[] nums = new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int k = 4;
        int actual = new Solution().findKthLargest(nums, k);
        assertEquals(expected, actual);
    }

}
