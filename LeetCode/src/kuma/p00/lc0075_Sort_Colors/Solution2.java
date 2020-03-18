package kuma.p00.lc0075_Sort_Colors;

public class Solution2 {
    public void sortColors(int[] nums) {
        int[] arr = new int[3];
        for (int num : nums)
            arr[num]++;

        for (int i = 0; i < nums.length; i++) {
            if (i < arr[0])
                nums[i] = 0;
            else if (i < arr[0] + arr[1])
                nums[i] = 1;
            else
                nums[i] = 2;
        }
    }
}
