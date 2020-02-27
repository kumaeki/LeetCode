package kuma.lc0041_First_Missing_Positive;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            while (i + 1 != nums[i]) {
                int index = nums[i] - 1;
                if (index < 0 || index >= len || index + 1 == nums[index]) {
                    nums[i] = 0;
                    break;
                } else
                    swap(nums, i, index);
            }
        }

        for (int i = 0; i < len; i++)
            if (nums[i] == 0)
                return i + 1;

        return len + 1;

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
