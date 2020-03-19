package kuma.p02.lc0283_Move_Zeroes;

class Solution2 {
    public void moveZeroes(int[] nums) {
        int len = nums.length, count = 0;
        int indexZero = len;
        for (int i = 0; i < len; i++)
            if (nums[i] == 0) {
                indexZero = i;
                count++;
                break;
            }

        for (int i = indexZero + 1; i < len; i++) {
            if (nums[i] != 0) {
                nums[indexZero++] = nums[i];
            } else
                count++;
        }

        for (int i = 0; i < count; i++)
            nums[len - 1 - i] = 0;

    }
}
