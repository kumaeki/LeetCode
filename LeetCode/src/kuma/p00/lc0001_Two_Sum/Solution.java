package kuma.p00.lc0001_Two_Sum;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int num, index;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(len);
        for (int i = 0; i < len; i++) {
            num = nums[i];
            index = map.getOrDefault(target - num, -1);
            if (index >= 0)
                return new int[] { i, index };
            else
                map.put(num, i);
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int num = target - nums[i];
            for (int j = i + 1; j < len; j++) {
                if (nums[j] == num)
                    return new int[] { i, j };
            }
        }
        return null;
    }

    @Test
    public void TestSimple1() {
        int[] nums = new int[] { 3, 2, 4 };
        int target = 6;
        int[] actuals = twoSum(nums, target);
        int[] expected = new int[] { 1, 2 };

        Arrays.sort(actuals);
        Arrays.sort(expected);
        assertArrayEquals(expected, actuals);
    }

    @Test
    public void TestSimple2() {
        int[] nums = new int[] { 2, 7, 11, 15 };
        int target = 9;
        int[] actuals = twoSum(nums, target);
        int[] expected = new int[] { 0, 1 };

        Arrays.sort(actuals);
        Arrays.sort(expected);
        assertArrayEquals(expected, actuals);
    }

    @Test
    public void TestSimple3() {
        int[] nums = new int[] { 3, 3 };
        int target = 6;
        int[] actuals = twoSum(nums, target);
        int[] expected = new int[] { 0, 1 };

        Arrays.sort(actuals);
        Arrays.sort(expected);
        assertArrayEquals(expected, actuals);
    }
}
