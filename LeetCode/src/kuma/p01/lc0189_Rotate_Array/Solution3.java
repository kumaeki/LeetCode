package kuma.p01.lc0189_Rotate_Array;

public class Solution3 {
    // Runtime: 0 ms, faster than 100.00%
    // Memory Usage: 40.5 MB, less than 5.77%
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    private void reverse(int[] nums, int left, int right) {
        int temp;
        while(left < right) {
            temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}
