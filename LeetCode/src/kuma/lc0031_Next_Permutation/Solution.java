package kuma.lc0031_Next_Permutation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int j = len - 2; j >= 0; j--) {
            if (nums[j] < nums[j + 1]) {

                // get the min value that bigger than nums[j]
                int next = nums[j + 1];
                int index = j + 1;
                for (int k = j + 2; k <= len - 1; k++) {
                    if (nums[k] > nums[j] && nums[k] < next)
                        index = k;
                }

                // swop nums[i] and nums[index]
                int temp = nums[index];
                nums[index] = nums[j];
                nums[j] = temp;

                // sort numbers from j + 1 to the last
                helper(nums, j + 1, len - 1);
                return;
            }
        }
        // if is not possible , sort in ascending order
        helper(nums, 0, len - 1);
    }

    private void helper(int[] nums, int left, int right) {
        if (left >= right)
            return;

        int i = left, j = right;
        int temp = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= temp)
                j--;
            if (i < j)
                nums[i++] = nums[j];

            while (i < j && nums[i] <= temp)
                i++;
            if (i < j)
                nums[j--] = nums[i];
        }
        nums[i] = temp;

        helper(nums, left, i - 1);
        helper(nums, i + 1, right);
    }

    @Test
    public void testSimple4() {
        int[] expected = new int[] { 2, 1, 3 };
        int[] actual = new int[] { 1, 3, 2 };
        new Solution().nextPermutation(actual);
        for (int i = 0; i < expected.length; i++)
            assertEquals(expected[i], actual[i]);
    }

    @Test
    public void testSimple1() {
        int[] expected = new int[] { 3, 1, 2 };
        int[] actual = new int[] { 2, 3, 1 };
        new Solution().nextPermutation(actual);
        for (int i = 0; i < expected.length; i++)
            assertEquals(expected[i], actual[i]);
    }

    @Test
    public void testSimple3() {
        int[] expected = new int[] { 1, 5, 1 };
        int[] actual = new int[] { 1, 1, 5 };
        new Solution().nextPermutation(actual);
        for (int i = 0; i < expected.length; i++)
            assertEquals(expected[i], actual[i]);
    }

    @Test
    public void testSimple2() {
        int[] expected = new int[] { 1, 2, 3 };
        int[] actual = new int[] { 3, 2, 1 };
        new Solution().nextPermutation(actual);
        for (int i = 0; i < expected.length; i++)
            assertEquals(expected[i], actual[i]);
    }

    @Test
    public void testSimple5() {
        int[] expected = new int[] { 4, 2, 0, 3, 0, 2, 2 };
        int[] actual = new int[] { 4, 2, 0, 2, 3, 2, 0 };
        new Solution().nextPermutation(actual);
        for (int i = 0; i < expected.length; i++)
            assertEquals(expected[i], actual[i]);
    }
}
