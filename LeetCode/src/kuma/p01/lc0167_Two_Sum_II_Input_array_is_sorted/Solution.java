package kuma.p01.lc0167_Two_Sum_II_Input_array_is_sorted;

public class Solution {
    // Runtime: 2 ms, faster than 23.54%
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        for (int i = 0; i < len - 1; i++) {
            int k = target - numbers[i];
            int left = i + 1, right = len - 1, mid;
            while (left <= right) {
                mid = (left + right) / 2;
                if (numbers[mid] < k)
                    left = mid + 1;
                else if (numbers[mid] > k)
                    right = mid - 1;
                else
                    return new int[] { i + 1, mid + 1 };
            }
        }
        return null;
    }
}
