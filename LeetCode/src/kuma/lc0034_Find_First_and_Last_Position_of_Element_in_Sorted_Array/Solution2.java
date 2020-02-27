package kuma.lc0034_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[] { -1, -1 };

        int left = 0, right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
            else {
                index = mid;
                break;
            }
        }

        if (index == -1)
            return new int[] { -1, -1 };

        int[] res = new int[2];
        left = 0;
        right = index;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] == target)
                right = mid - 1;
        }
        res[0] = left;

        left = index;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target)
                right = mid - 1;
            else if (nums[mid] == target)
                left = mid + 1;
        }
        res[1] = right;

        return res;
    }

    @Test
    public void testSimple1() {
        int[] expecteds = new int[] { 3, 4 };
        int[] nums = new int[] { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        int[] actuals = new Solution2().searchRange(nums, target);
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void testSimple2() {
        int[] expecteds = new int[] { 1, 2 };
        int[] nums = new int[] { 5, 7, 7, 8, 8, 10 };
        int target = 7;
        int[] actuals = new Solution2().searchRange(nums, target);
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void testSimple3() {
        int[] expecteds = new int[] { 0, 5 };
        int[] nums = new int[] { 7, 7, 7, 7, 7, 7 };
        int target = 7;
        int[] actuals = new Solution2().searchRange(nums, target);
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void testSimple4() {
        int[] expecteds = new int[] { -1, -1 };
        int[] nums = new int[] { 7, 7, 7, 7, 7, 7 };
        int target = 8;
        int[] actuals = new Solution2().searchRange(nums, target);
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void testSimple5() {
        int[] expecteds = new int[] { 0, 0 };
        int[] nums = new int[] { 7 };
        int target = 7;
        int[] actuals = new Solution2().searchRange(nums, target);
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void testSimple6() {
        int[] expecteds = new int[] { -1, -1 };
        int[] nums = new int[] { 6 };
        int target = 7;
        int[] actuals = new Solution2().searchRange(nums, target);
        assertArrayEquals(expecteds, actuals);
    }
    
    @Test
    public void testEmpty() {
        int[] expecteds = new int[] { -1, -1 };
        int[] nums = new int[] {};
        int target = 7;
        int[] actuals = new Solution2().searchRange(nums, target);
        assertArrayEquals(expecteds, actuals);
    }
}
