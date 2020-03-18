package kuma.p00.lc0015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> reslist = new ArrayList<List<Integer>>();
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int target = 0 - nums[i];
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    reslist.add(Arrays.asList(new Integer[] { nums[i], nums[left++], nums[right--] }));
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                } else if (sum < target)
                    left++;
                else
                    right--;
            }

        }
        return reslist;
    }

}
