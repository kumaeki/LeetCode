package kuma.p02.lc0228_Summary_Ranges;

import java.util.*;

public class Solution2 {
    // Runtime: 0 ms, faster than 100.00%
    // Memory Usage: 37.8 MB, less than 6.67%
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1])
                i++;
            if (nums[i] != num)
                list.add(getStr(num, nums[i]));
        }
        return list;
    }

    private String getStr(int start, int end) {
        StringBuilder sb = new StringBuilder(String.valueOf(start));
        if (start == end)
            return sb.toString();
        else
            return sb.append("->").append(end).toString();
    }
}
