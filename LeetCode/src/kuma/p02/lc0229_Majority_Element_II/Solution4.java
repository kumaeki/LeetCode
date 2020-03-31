package kuma.p02.lc0229_Majority_Element_II;

import static org.junit.Assert.assertArrayEquals;

import java.util.*;

import org.junit.Test;

public class Solution4 {
    // Runtime: 1 ms, faster than 99.90% of Java online submissions for Majority
    // Element II.
    // Memory Usage: 45.4 MB, less than 7.27% of Java online submissions for
    // Majority Element II.

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        int len = nums.length;
        if (len > 0) {
            int t1 = len / 3, t2 = 2 * len / 3;
            findCandidate(nums, 0, len - 1, t1);
            findCandidate(nums, 0, len - 1, t2);
            if (isMajority(nums, nums[t1]))
                res.add(nums[t1]);
            if (nums[t1] != nums[t2] && isMajority(nums, nums[t2]))
                res.add(nums[t2]);
        }
        return res;
    }

    private void findCandidate(int[] nums, int start, int end, int t) {
        while (start < end) {
            int j = sortArr(nums, start, end);
            if (j < t)
                start = j + 1;
            else if (j > t)
                end = j - 1;
            else
                break;
        }
    }

    private int sortArr(int[] nums, int start, int end) {
        int i = start, j = end + 1;
        int val = nums[start];
        while (true) {
            while (nums[++i] < val)
                if (i == end)
                    break;
            while (nums[--j] > val)
                if (start == j)
                    break;
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, start, j);
        return j;
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
        assertArrayEquals(new Integer[] {}, new Solution4().majorityElement(new int[] {}).toArray(new Integer[] {}));
    }

    @Test
    public void simple1() {
        assertArrayEquals(new Integer[] { 3 },
                new Solution4().majorityElement(new int[] { 3, 2, 3 }).toArray(new Integer[1]));
    }

    @Test
    public void simple2() {
        assertArrayEquals(new Integer[] { 1, 2 },
                new Solution4().majorityElement(new int[] { 1, 1, 1, 3, 3, 2, 2, 2 }).toArray(new Integer[2]));
    }

    @Test
    public void simple3() {
        assertArrayEquals(new Integer[] { 1 },
                new Solution4().majorityElement(new int[] { 1 }).toArray(new Integer[1]));
    }

    @Test
    public void simple4() {
        assertArrayEquals(new Integer[] { 1, 2 },
                new Solution4().majorityElement(new int[] { 1, 2 }).toArray(new Integer[2]));
    }

    @Test
    public void simple5() {
        assertArrayEquals(new Integer[] { 0 },
                new Solution4()
                        .majorityElement(new int[] { 1, 2, 0, 4, 5, 0, 6, 7, 8, 9, 9, 9, 9, 9, 9, 0, 0, 0, 0, 0 })
                        .toArray(new Integer[1]));
    }
}
