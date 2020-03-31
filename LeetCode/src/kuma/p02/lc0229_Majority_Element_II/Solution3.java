package kuma.p02.lc0229_Majority_Element_II;

import static org.junit.Assert.assertArrayEquals;

import java.util.*;

import org.junit.Test;

public class Solution3 {
    // Runtime: 686 ms, faster than 5.14% of Java online submissions for Majority
    // Element II.
    // Memory Usage: 45.4 MB, less than 7.27% of Java online submissions for
    // Majority Element II.

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        int len = nums.length;
        if (len > 0) {
            int t1 = len / 3, t2 = 2 * len / 3;
            sortArr(nums, 0, len - 1, t1);
            sortArr(nums, t1, len - 1, t2);
            if (isMajority(nums, nums[t1]))
                res.add(nums[t1]);
            if (nums[t1] != nums[t2] && isMajority(nums, nums[t2]))
                res.add(nums[t2]);
        }
        return res;
    }

    private void sortArr(int[] nums, int start, int end, int t) {
        if(start >= end)
            return;
        swap(nums, (start + end) / 2, end);
        int index = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= nums[end])
                swap(nums, index++, i);
        }
        swap(nums, index, end);
        if (index < t)
            sortArr(nums, index + 1, end, t);
        else if (index > t)
            sortArr(nums, start, index - 1, t);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private boolean isMajority(int[] nums, int cand) {
        int count = 0;
        for (int num : nums)
            if (num == cand)
                count++;
        return count > nums.length / 3;
    }

    @Test
    public void empty() {
        assertArrayEquals(new Integer[] {}, new Solution3().majorityElement(new int[] {}).toArray(new Integer[] {}));
    }

    @Test
    public void simple1() {
        assertArrayEquals(new Integer[] { 3 },
                new Solution3().majorityElement(new int[] { 3, 2, 3 }).toArray(new Integer[1]));
    }

    @Test
    public void simple2() {
        assertArrayEquals(new Integer[] { 1, 2 },
                new Solution3().majorityElement(new int[] { 1, 1, 1, 3, 3, 2, 2, 2 }).toArray(new Integer[2]));
    }

    @Test
    public void simple3() {
        assertArrayEquals(new Integer[] { 1 },
                new Solution3().majorityElement(new int[] { 1 }).toArray(new Integer[1]));
    }

    @Test
    public void simple4() {
        assertArrayEquals(new Integer[] { 1, 2 },
                new Solution3().majorityElement(new int[] { 1, 2 }).toArray(new Integer[2]));
    }

    @Test
    public void simple5() {
        assertArrayEquals(new Integer[] { 0 },
                new Solution3()
                        .majorityElement(new int[] { 1, 2, 0, 4, 5, 0, 6, 7, 8, 9, 9, 9, 9, 9, 9, 0, 0, 0, 0, 0 })
                        .toArray(new Integer[1]));
    }
}
