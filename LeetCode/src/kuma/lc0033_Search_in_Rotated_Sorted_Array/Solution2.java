package kuma.lc0033_Search_in_Rotated_Sorted_Array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution2 {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        int res = findTarget(nums, pivot, nums.length - 1, target);
        if (pivot > 0 && res == -1)
            res = findTarget(nums, 0, pivot - 1, target);
        return res;
    }

    private int findPivot(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid > 0 && nums[mid - 1] > nums[mid])
                return mid;
            else if (nums[mid] < nums[0])
                right = mid;
            else if (nums[mid] > nums[nums.length - 1])
                left = mid + 1;
            else
                return 0;
        }
        return 0;
    }

    private int findTarget(int[] nums, int left, int right, int target) {
        if (left > right)
            return -1;
        int mid = (left + right) / 2;
        if (nums[mid] < target)
            return findTarget(nums, mid + 1, right, target);
        else if (nums[mid] > target)
            return findTarget(nums, left, mid - 1, target);
        else
            return mid;
    }

    @Test
    public void testSimple1() {
        int expected = 4;
        int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        int actual = new Solution2().search(nums, target);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple2() {
        int expected = -1;
        int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        int target = 8;
        int actual = new Solution2().search(nums, target);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple3() {
        int expected = -1;
        int[] nums = new int[] { 3, 1 };
        int target = 0;
        int actual = new Solution2().search(nums, target);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple4() {
        int expected = 1;
        int[] nums = new int[] { 3, 1 };
        int target = 1;
        int actual = new Solution2().search(nums, target);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple5() {
        int expected = 0;
        int[] nums = new int[] { 3, 1 };
        int target = 3;
        int actual = new Solution2().search(nums, target);
        assertEquals(expected, actual);
    }

}
