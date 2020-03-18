package kuma.p00.lc0075_Sort_Colors;

public class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (int i = left; i <= right; i++) {
            while (nums[i] != 1) {
                if (nums[i] == 0 && i > left) {
                    swap(nums, i, left++);
                } else if (nums[i] == 2 && i < right) {
                    swap(nums, i, right--);
                } else
                    break;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
