package kuma.p04.lc0442_Find_All_Duplicates_in_an_Array;

import java.util.*;

public class Solution {
    // Runtime: 17 ms, faster than 17.54% of Java online submissions for Find All
    // Duplicates in an Array.
    // Memory Usage: 48.9 MB, less than 36.11% of Java online submissions for Find
    // All Duplicates in an Array.
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
                res.add(num);
            } else
                set.add(num);
        }
        return res;
    }
}
