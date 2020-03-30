package kuma.p01.lc0167_Two_Sum_II_Input_array_is_sorted;

public class Solution4 {
    // Runtime: 0 ms, faster than 100.00%
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int sum;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum < target)
                left = findSmallestlargeOrFirstEqual(numbers, left, right, target - numbers[right]);
            else if (sum > target)
                right = findlargestSmallerOrFirstEqual(numbers, left, right, target - numbers[left]);
            else
                return new int[] { left + 1, right + 1 };
        }
        return null;
    }

    private int findSmallestlargeOrFirstEqual(int[] nums, int left, int right, int target) {
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }

    private int findlargestSmallerOrFirstEqual(int[] nums, int left, int right, int target) {
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] <= target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return right;
    }
}
