package kuma.p02.lc0228_Summary_Ranges;

import java.util.*;

public class Solution {
    // Runtime: 0 ms, faster than 100.00%
    // Memory Usage: 37.6 MB, less than 6.67%
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        if (nums == null || nums.length == 0)
            return list;

        int start = nums[0], end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                list.add(getStr(start, end));
                start = nums[i];
            }
            end = nums[i];
        }
        list.add(getStr(start, end));
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
