package kuma.p00.lc0047_Permutations_II;

import java.util.*;

public class Solution2 {
    // Runtime: 3 ms, faster than 33.88% of Java online submissions for Permutations
    // II.
    // Memory Usage: 44.5 MB, less than 5.97% of Java online submissions for
    // Permutations II.
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, new ArrayList<Integer>(n), nums, new boolean[n]);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] visited) {
        if (list.size() == nums.length)
            res.add(new ArrayList<Integer>(list));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (visited[i])
                    continue;
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                    continue;
                list.add(nums[i]);
                visited[i] = true;
                helper(res, list, nums, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        new Solution2().permuteUnique(new int[] { 1, 1, 2 });
    }
}
