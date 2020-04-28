package kuma.p00.lc0051_N_Queens;

import java.util.*;

public class Solution {
    // Runtime: 10 ms, faster than 14.82% of Java online submissions for N-Queens.
    // Memory Usage: 40.4 MB, less than 8.11% of Java online submissions for
    // N-Queens.
    public List<List<String>> solveNQueens(int n) {
        String[] arr = new String[n];
        int[] nums = new int[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++)
            sb.append('.');

        for (int i = 0; i < n; i++) {
            arr[i] = sb.substring(0, i) + 'Q' + sb.substring(i);
            nums[i] = i;
        }

        List<List<Integer>> listInt = new ArrayList<List<Integer>>();
        helper(listInt, new ArrayList<Integer>(n), nums, new boolean[n], new HashSet<Integer>(),
                new HashSet<Integer>());

        List<List<String>> res = new ArrayList<List<String>>();
        for (List<Integer> list : listInt) {
            List<String> liststr = new ArrayList<String>();
            for (int index : list)
                liststr.add(arr[index]);
            res.add(liststr);
        }
        return res;
    }

    private void helper(List<List<Integer>> listInt, List<Integer> list, int[] nums, boolean[] visited,
            Set<Integer> set1, Set<Integer> set2) {
        if (list.size() == nums.length) {
            listInt.add(new ArrayList<Integer>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (visited[i])
                    continue;
                int slope1 = nums[i] - list.size(), slope2 = list.size() + nums[i];
                if (set1.contains(slope1) && set2.contains(slope2)) {
                    set1.add(slope1);
                    set2.add(slope2);
                    list.add(nums[i]);
                    visited[i] = true;
                    helper(listInt, list, nums, visited, set1, set2);
                    list.remove(list.size() - 1);
                    visited[i] = false;
                    set1.remove(slope1);
                    set2.remove(slope2);
                }

            }
        }
    }

    public static void main(String[] args) {
        new Solution().solveNQueens(5);
    }
}
