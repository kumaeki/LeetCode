package kuma.p07.lc0724_Find_Pivot_Index;

public class Solution {
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Find Pivot
    // Index.
    // Memory Usage: 39.9 MB, less than 97.87% of Java online submissions for Find
    // Pivot Index.
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] forward = new int[len + 1], backward = new int[len + 1];
        for (int i = 1; i <= len; i++)
            forward[i] = forward[i - 1] + nums[i - 1];

        for (int i = len - 1; i >= 0; i--)
            backward[i] = backward[i + 1] + nums[i];

        for (int i = 0; i < len; i++)
            if (forward[i] == backward[i + 1])
                return i;
        return -1;
    }
}
