package kuma.p06.lc0670_Maximum_Swap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum
    // Swap.
    // Memory Usage: 36 MB, less than 25.00% of Java online submissions for Maximum
    // Swap.
    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int[] nums = new int[10];
        for (int i = 0; i < arr.length; i++)
            nums[arr[i] - '0'] = i;

        for (int i = 0; i < arr.length; i++)
            for (int j = 9; j > arr[i] - '0'; j--) {
                int right = nums[j];
                if (right > i) {
                    char temp = arr[i];
                    arr[i] = arr[right];
                    arr[right] = temp;
                    return Integer.valueOf(new String(arr));
                }
            }

        return num;
    }

    @Test
    public void simple1() {
        assertEquals(7236, new Solution().maximumSwap(2736));
    }

    @Test
    public void simple2() {
        assertEquals(9632, new Solution().maximumSwap(9236));
    }

    @Test
    public void simple3() {
        assertEquals(9986, new Solution().maximumSwap(9986));
    }
}
