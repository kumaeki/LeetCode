package kuma.p00.lc0016_3Sum_Closest;

public class Solution {
    // Runtime: 111 ms, faster than 7.28% of Java online submissions for 3Sum
    // Closest.
    // Memory Usage: 38.9 MB, less than 6.67% of Java online submissions for 3Sum
    // Closest.

    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length, res = target, min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int a = nums[i];
            for (int j = i + 1; j < n - 1; j++) {
                int b = a + nums[j];
                for (int k = j + 1; k < n; j++) {
                    int c = b + nums[k];
                    int dif = Math.abs(target - c);
                    if (dif < min) {
                        min = dif;
                        res = c;
                    }
                }
            }
        }
        return res;
    }
}
