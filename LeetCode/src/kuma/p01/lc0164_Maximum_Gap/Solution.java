package kuma.p01.lc0164_Maximum_Gap;

import java.util.*;

public class Solution {
    // 最简单的做法,用系统提供的排序方法对nums进行排序,然后遍历得到相邻两个元素的差值的最大值.
    // Runtime: 2 ms, faster than 93.27% of Java online submissions for Maximum Gap.
    // Memory Usage: 39.9 MB, less than 6.90% of Java online submissions for Maximum
    // Gap.
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 1; i < nums.length; i++)
            res = Math.max(res, nums[i] - nums[i - 1]);
        return res;
    }
}
