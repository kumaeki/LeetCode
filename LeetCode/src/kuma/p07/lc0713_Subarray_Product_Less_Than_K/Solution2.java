package kuma.p07.lc0713_Subarray_Product_Less_Than_K;

public class Solution2 {
    // Runtime: 94 ms, faster than 5.60% of Java online submissions for Subarray
    // Product Less Than K.
    // Memory Usage: 48.7 MB, less than 100.00% of Java online submissions for
    // Subarray Product Less Than K.
    
    // (logs[mid] - logs[i] < logk - 1e-9)
    // don't understand
    
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int len = nums.length;
        double logk = Math.log(k);
        double[] logs = new double[len + 1];
        for (int i = 1; i < len + 1; i++)
            logs[i] = logs[i - 1] + Math.log(nums[i - 1]);

        int count = 0;
        for (int i = 0; i < len + 1; i++) {
            int left = i + 1, right = len + 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (logs[mid] - logs[i] < logk - 1e-9)
                    left = mid + 1;
                else
                    right = mid;
            }
            count += (left - i - 1);
        }
        return count;
    }

}
