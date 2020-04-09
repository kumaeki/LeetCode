package kuma.p07.lc0724_Find_Pivot_Index;

public class Solution2 {
    // Runtime: 2 ms, faster than 33.95% of Java online submissions for Find Pivot
    // Index.
    // Memory Usage: 40.1 MB, less than 97.87% of Java online submissions for Find
    // Pivot Index.
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] forward = new int[len + 1];
        for (int i = 1; i <= len; i++)
            forward[i] = forward[i - 1] + nums[i - 1];

        for (int i = 0; i < len; i++)
            if (forward[i] == forward[len] - forward[i + 1])
                return i;
        return -1;
    }
}
