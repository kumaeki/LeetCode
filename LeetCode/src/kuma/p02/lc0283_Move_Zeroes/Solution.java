package kuma.p02.lc0283_Move_Zeroes;

class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length, index0 = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0)
                continue;
            while (index0 < len && nums[index0] != 0)
                index0++;

            if (index0 > i)
                continue;
            if (index0 >= len)
                break;

            int temp = nums[index0];
            nums[index0] = nums[i];
            nums[i] = temp;
        }

    }
}
