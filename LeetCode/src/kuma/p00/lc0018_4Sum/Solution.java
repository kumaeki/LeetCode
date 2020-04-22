package kuma.p00.lc0018_4Sum;

import java.util.*;

public class Solution {
    // Runtime: 12 ms, faster than 84.23% of Java online submissions for 4Sum.
    // Memory Usage: 39.8 MB, less than 63.77% of Java online submissions for 4Sum.
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    private List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (start == len)
            return res;
        if (k == 2) {
            int left = start, right = len - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    res.add(new ArrayList<Integer>(Arrays.asList(new Integer[] { nums[left++], nums[right--] })));
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                    while (left < right && nums[right + 1] == nums[right])
                        right--;
                } else if (sum < target)
                    left++;
                else
                    right--;
            }
        } else {
            for (int i = start; i < len - k + 1; i++) {
                if (i > start && nums[i] == nums[i - 1])
                    continue;
                for (List<Integer> t : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    t.add(0, nums[i]);
                    res.add(t);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        for (List<Integer> list : new Solution().fourSum(new int[] { -2, -1, 0, 0, 1, 2 }, 0)) {
            list.forEach(y -> System.out.print(y + ", "));
            System.out.println("");
        }

    }
}
