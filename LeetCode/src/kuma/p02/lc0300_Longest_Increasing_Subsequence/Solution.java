package kuma.p02.lc0300_Longest_Increasing_Subsequence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import java.util.*;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        List<Integer> dp = new ArrayList<Integer>(len);
        int index;
        for (int num : nums) {
            index = Collections.binarySearch(dp, num);
            if (index < 0)
                index = -(index + 1);

            if (index == dp.size())
                dp.add(num);
            else
                dp.set(index, num);

        }
        return dp.size();
    }

    @Test
    public void simple1() {
        int expected = 4;
        int[] nums = new int[] { 10, 9, 2, 5, 3, 7, 101, 18 };
        int actual = new Solution().lengthOfLIS(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        int expected = 1;
        int[] nums = new int[] { 4, 4, 4, 4 };
        int actual = new Solution().lengthOfLIS(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void simple3() {
        int expected = 3;
        int[] nums = new int[] { 4, 10, 4, 3, 8, 9 };
        int actual = new Solution().lengthOfLIS(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void simple4() {
        int expected = 2;
        int[] nums = new int[] { 3, 1, 2 };
        int actual = new Solution().lengthOfLIS(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void simple5() {
        int expected = 6;
        int[] nums = new int[] { 1, 3, 6, 7, 9, 4, 10, 5, 6 };
        int actual = new Solution().lengthOfLIS(nums);
        assertEquals(expected, actual);
    }
}
