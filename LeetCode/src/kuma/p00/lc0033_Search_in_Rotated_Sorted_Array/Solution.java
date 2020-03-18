package kuma.p00.lc0033_Search_in_Rotated_Sorted_Array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        int valR = nums[right];
        while (left < right) {
            int mid = (left + right) / 2;
            if ((nums[mid] - valR) * (target - valR) > 0) {
                if (nums[mid] < target)
                    left = mid + 1;
                else if (nums[mid] > target)
                    right = mid;
                else
                    return mid;
            } else if (target > valR)
                right = mid;
            else
                left = mid + 1;
        }

        if (nums[left] == target)
            return left;
        else
            return -1;
    }

    @Test
    public void testSimple1() {
        int expected = 4;
        int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        int actual = new Solution().search(nums, target);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple2() {
        int expected = -1;
        int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        int target = 8;
        int actual = new Solution().search(nums, target);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple3() {
        int expected = -1;
        int[] nums = new int[] { 3, 1 };
        int target = 0;
        int actual = new Solution().search(nums, target);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple4() {
        int expected = 1;
        int[] nums = new int[] { 3, 1 };
        int target = 1;
        int actual = new Solution().search(nums, target);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple5() {
        int expected = 0;
        int[] nums = new int[] { 3, 1 };
        int target = 3;
        int actual = new Solution().search(nums, target);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple6() {
        int expected = 1;
        int[] nums = new int[] { 1, 3 };
        int target = 3;
        int actual = new Solution().search(nums, target);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple7() {
        int expected = 0;
        int[] nums = new int[] { 1, 3 };
        int target = 1;
        int actual = new Solution().search(nums, target);
        assertEquals(expected, actual);
    }
}
