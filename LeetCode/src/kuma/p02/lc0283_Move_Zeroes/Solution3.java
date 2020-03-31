package kuma.p02.lc0283_Move_Zeroes;

class Solution3 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Move
    // Zeroes.
    // Memory Usage: 39.5 MB, less than 33.57% of Java online submissions for Move
    // Zeroes.
    public void moveZeroes(int[] nums) {
        int len = nums.length, index = 0;
        for (int i = 0; i < len; i++)
            if (nums[i] != 0)
                nums[index++] = nums[i];

        while (index < len)
            nums[index++] = 0;
    }
}
