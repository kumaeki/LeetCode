package kuma.p00.lc0080_Remove_Duplicates_from_Sorted_Array_II;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Solution {
    // Runtime: 1 ms, faster than 20.20% of Java online submissions for Remove
    // Duplicates from Sorted Array II.
    // Memory Usage: 39.7 MB, less than 5.26% of Java online submissions for Remove
    // Duplicates from Sorted Array II.
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3)
            return nums.length;

        int left = 1, right = 1, count = 1, n = nums.length;
        while (left <= right && right < n) {
            count = 1;
            while (left < n) {
                if (nums[left] < nums[left - 1])
                    break;
                else if (nums[left] == nums[left - 1]) {
                    if (count == 2)
                        break;
                    else
                        count++;
                } else
                    count = 1;
                left++;
            }

            int pre = nums[left - 1];
            right = Math.max(left, right) + 1;
            while (right < n) {
                if (nums[right] > pre)
                    break;
                if (nums[right] == pre && left > 1 && pre != nums[left - 2])
                    break;
                right++;
            }
            if (right < n) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            left++;
        }

        return left - 1;
    }

    @Test
    public void simple1() {
        assertEquals(5, new Solution().removeDuplicates(new int[] { 1, 1, 1, 2, 2, 3 }));
    }

    @Test
    public void simple2() {
        assertEquals(7, new Solution().removeDuplicates(new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 }));
    }
}
