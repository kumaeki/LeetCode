package kuma.p06.lc0611_Valid_Triangle_Number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Solution3 {
    // Runtime: 54 ms, faster than 31.65% of Java online submissions for Valid
    // Triangle Number.
    // Memory Usage: 40.1 MB, less than 30.00% of Java online submissions for Valid
    // Triangle Number.
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0, len = nums.length, target, preIndex;
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] == 0)
                continue;
            preIndex = i + 2;
            for (int j = i + 1; j < len - 1; j++) {
                target = nums[i] + nums[j];
                int index = search(nums, target, preIndex);
                if (index > 0) {
                    count += (index - j);
                    preIndex = index + 1;
                }

            }
        }
        return count;
    }

    public int search(int[] nums, int target, int start) {
        int left = start, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (right + left) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return nums[right] < target ? right : -1;
    }

    @Test
    public void simple1() {
        assertEquals(3, new Solution3().triangleNumber(new int[] { 2, 2, 3, 4 }));
    }

    @Test
    public void simple2() {
        assertEquals(0, new Solution3().triangleNumber(new int[] { 0, 1, 0, 1 }));
    }

    @Test
    public void simple3() {
        assertEquals(4, new Solution3().triangleNumber(new int[] { 2, 2, 3, 3 }));
    }
}
