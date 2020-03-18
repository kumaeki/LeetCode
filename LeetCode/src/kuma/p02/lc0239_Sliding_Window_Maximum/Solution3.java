package kuma.p02.lc0239_Sliding_Window_Maximum;

class Solution3 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return new int[] {};

        int len = nums.length;
        int[] left = new int[len], right = new int[len];

        int max = nums[0];
        for (int i = 0; i < len; i++) {
            if (i % k == 0)
                max = nums[i];
            else
                max = Math.max(max, nums[i]);
            left[i] = max;
        }

        max = nums[len - 1];
        for (int i = len - 1; i >= 0; i--) {
            if (i % k == k - 1)
                max = nums[i];
            else
                max = Math.max(max, nums[i]);
            right[i] = max;
        }

        int[] res = new int[len - k + 1];
        for (int i = 0; i < len - k + 1; i++) {
            res[i] = Math.max(left[i + k - 1], right[i]);
        }

        return res;
    }
}
