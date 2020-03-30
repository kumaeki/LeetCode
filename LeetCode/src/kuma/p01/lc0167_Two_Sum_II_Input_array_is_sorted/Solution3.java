package kuma.p01.lc0167_Two_Sum_II_Input_array_is_sorted;

public class Solution3 {
    // Runtime: 0 ms, faster than 100.00%
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int sum;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum < target)
                left++;
            else if (sum > target)
                right--;
            else
                return new int[] { left + 1, right + 1 };
        }

        return null;
    }
}
