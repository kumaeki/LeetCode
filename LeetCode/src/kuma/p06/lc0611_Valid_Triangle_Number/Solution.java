package kuma.p06.lc0611_Valid_Triangle_Number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Solution {
    // Runtime: 105 ms, faster than 23.96% of Java online submissions for Valid
    // Triangle Number.
    // Memory Usage: 40.4 MB, less than 20.00% of Java online submissions for Valid
    // Triangle Number.
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0, len = nums.length, target;
        for (int i = 0; i < len - 2; i++)
            for (int j = i + 1; j < len - 1; j++) {
                target = nums[i] + nums[j];
                int index = search(nums, target, j + 1);
                if (index > 0)
                    count += (index - j);
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
        assertEquals(3, new Solution().triangleNumber(new int[] { 2, 2, 3, 4 }));
    }
}
