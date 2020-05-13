package kuma.p01.lc0137_Single_Number_II;

public class Solution2 {
    // Runtime: 3 ms, faster than 58.59% of Java online submissions for Single
    // Number II.
    // Memory Usage: 39.5 MB, less than 5.26% of Java online submissions for Single
    // Number II.
    public int singleNumber(int[] nums) {
        int[] arr = new int[32];
        for (int i = 0, n = nums.length; i < n; i++) {
            int num = nums[i];
            for (int j = 0; j < 32; j++)
                if (((num >> j) & 1) == 1)
                    arr[j]++;
        }

        int res = 0;
        for (int j = 0; j < 32; j++)
            if (arr[j] % 3 == 1)
                res |= 1 << j;
        return res;
    }
}
