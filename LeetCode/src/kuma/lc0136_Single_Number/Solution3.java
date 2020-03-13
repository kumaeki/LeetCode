package kuma.lc0136_Single_Number;

import java.util.*;

public class Solution3 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 1; i < len - 1; i++)
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1])
                return nums[i];

        if (len > 1 && nums[len - 1] != nums[len - 2])
            return nums[len - 1];

        return nums[0];
    }

}
