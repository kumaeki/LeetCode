package kuma.p00.lc0051_N_Queens_II;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Runtime: 1 ms, faster than 81.76% of Java online submissions for N-Queens II.
    // Memory Usage: 36.4 MB, less than 8.70% of Java online submissions for
    // N-Queens II.
    public int totalNQueens(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = i;

        List<List<Integer>> listInt = new ArrayList<List<Integer>>();
        helper(listInt, new ArrayList<Integer>(n), nums, new boolean[n], new int[2 * n - 1], new int[2 * n - 1]);

        return listInt.size();
    }

    private void helper(List<List<Integer>> listInt, List<Integer> list, int[] nums, boolean[] visited, int[] set1,
            int[] set2) {
        if (list.size() == nums.length) {
            listInt.add(new ArrayList<Integer>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (visited[i])
                    continue;
                int slope1 = nums[i] - list.size() + nums.length - 1, slope2 = list.size() + nums[i];
                if (set1[slope1] == 0 && set2[slope2] == 0) {
                    set1[slope1] = 1;
                    set2[slope2] = 1;
                    list.add(nums[i]);
                    visited[i] = true;
                    helper(listInt, list, nums, visited, set1, set2);
                    list.remove(list.size() - 1);
                    visited[i] = false;
                    set1[slope1] = 0;
                    set2[slope2] = 0;
                }

            }
        }
    }
}
