package kuma.p08.lc0830_Positions_of_Large_Groups;

import java.util.*;

class Solution {
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Positions
    // of Large Groups.
    // Memory Usage: 39.8 MB, less than 36.84% of Java online submissions for
    // Positions of Large Groups.
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int left = 0, right = 0;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == S.charAt(left)) {
                right = i;
            } else {
                if (right - left > 1) {
                    List<Integer> list = new ArrayList<Integer>(2);
                    list.add(left);
                    list.add(right);
                    res.add(list);
                }
                left = i;
                right = i;
            }
        }
        if (right - left > 1) {
            List<Integer> list = new ArrayList<Integer>(2);
            list.add(left);
            list.add(right);
            res.add(list);
        }
        return res;
    }
}
