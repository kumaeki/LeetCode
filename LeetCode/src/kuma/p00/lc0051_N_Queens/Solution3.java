package kuma.p00.lc0051_N_Queens;

import java.util.*;

public class Solution3 {
    // Runtime: 2 ms, faster than 92.82% of Java online submissions for N-Queens.
    // Memory Usage: 39.4 MB, less than 27.03% of Java online submissions for
    // N-Queens.
    public List<List<String>> solveNQueens(int n) {
        char[] word = new char[n];
        String[] arr = new String[n];
        int[] nums = new int[n];
        for (int i = 0; i < n - 1; i++)
            word[i] = '.';

        for (int i = 0; i < n; i++) {
            word[i] = 'Q';
            arr[i] = new String(word);
            word[i] = '.';
            nums[i] = i;
        }

        List<List<Integer>> listInt = new ArrayList<List<Integer>>();
        helper(listInt, new ArrayList<Integer>(n), nums, new boolean[n], new int[2 * n - 1], new int[2 * n - 1]);

        List<List<String>> res = new ArrayList<List<String>>();
        for (List<Integer> list : listInt) {
            List<String> liststr = new ArrayList<String>();
            for (int index : list)
                liststr.add(arr[index]);
            res.add(liststr);
        }
        return res;
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

    public static void main(String[] args) {
        new Solution3().solveNQueens(5);
    }
}
