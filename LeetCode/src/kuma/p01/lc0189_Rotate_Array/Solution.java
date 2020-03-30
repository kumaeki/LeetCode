package kuma.p01.lc0189_Rotate_Array;

public class Solution {
    // Runtime: 0 ms, faster than 100.00% 
    // Memory Usage: 39.9 MB, less than 5.77%
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++)
            res[(i + k) % len] = nums[i];
        for (int i = 0; i < len; i++)
            nums[i] = res[i];
    }
}
