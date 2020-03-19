package kuma.p02.lc0283_Move_Zeroes;

class Solution3 {
    public void moveZeroes(int[] nums) {
        int index0 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, index0++, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }
}
