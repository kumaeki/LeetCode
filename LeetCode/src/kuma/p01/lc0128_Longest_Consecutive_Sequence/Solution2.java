package kuma.p01.lc0128_Longest_Consecutive_Sequence;

import java.util.*;

public class Solution2 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums)
            set.add(num);

        int res = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int max = 1;
                while (set.contains(num + 1)) {
                    num++;
                    max++;
                }
                res = Math.max(res, max);
            }
        }

        return res;
    }
}
