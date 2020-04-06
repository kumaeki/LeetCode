package kuma.p06.lc0611_Valid_Triangle_Number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Solution2 {
    // Runtime: 8 ms, faster than 78.70% of Java online submissions for Valid
    // Triangle Number.
    // Memory Usage: 39.4 MB, less than 30.00% of Java online submissions for Valid
    // Triangle Number.
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0, len = nums.length;
        for (int i = len - 1; i > 1; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i])
                    count += ((right--) - left);
                else
                    left++;
            }
        }
        return count;
    }

    @Test
    public void simple1() {
        assertEquals(3, new Solution2().triangleNumber(new int[] { 2, 2, 3, 4 }));
    }

    @Test
    public void simple2() {
        assertEquals(0, new Solution2().triangleNumber(new int[] { 0, 1, 0, 1 }));
    }

    @Test
    public void simple3() {
        assertEquals(4, new Solution2().triangleNumber(new int[] { 2, 2, 3, 3 }));
    }
}
