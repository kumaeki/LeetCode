package kuma.p02.lc0268_Missing_Number;

public class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Missing
    // Number.
    // Memory Usage: 39.8 MB, less than 100.00% of Java online submissions for
    // Missing Number.
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 1];
        for (int num : nums)
            arr[num] = 1;

        for (int i = 1; i < n + 1; i++)
            if (arr[i] == 0)
                return i;

        return 0;
    }
}
