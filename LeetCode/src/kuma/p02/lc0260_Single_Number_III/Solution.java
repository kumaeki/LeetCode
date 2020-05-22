package kuma.p02.lc0260_Single_Number_III;

import java.util.*;

public class Solution {
    // Runtime: 3 ms, faster than 39.83% of Java online submissions for Single
    // Number III.
    // Memory Usage: 39.6 MB, less than 33.33% of Java online submissions for Single
    // Number III.
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (!set.add(num))
                set.remove(num);
        }
        Iterator<Integer> i = set.iterator();
        return new int[] { i.next(), i.next() };
    }
}
