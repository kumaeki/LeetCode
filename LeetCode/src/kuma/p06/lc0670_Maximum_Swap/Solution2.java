package kuma.p06.lc0670_Maximum_Swap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution2 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum
    // Swap.
    // Memory Usage: 36 MB, less than 25.00% of Java online submissions for Maximum
    // Swap.
    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int[] nums = new int[10];
        for (char c : arr)
            nums[c - '0']++;

        for (int i = 9; i > 0; i--) {
            if (nums[i] == 0)
                continue;
            int max = i;

            int left = 0, right = arr.length - 1;
            while (right >= 0 && arr[right] != '0' + max)
                right--;
            while (left < right && arr[left] >= arr[right])
                left++;
            if (left < right && arr[left] < arr[right]) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                return Integer.valueOf(new String(arr));
            }
        }
        return num;
    }

    @Test
    public void simple1() {
        assertEquals(7236, new Solution2().maximumSwap(2736));
    }

    @Test
    public void simple2() {
        assertEquals(9632, new Solution2().maximumSwap(9236));
    }

    @Test
    public void simple3() {
        assertEquals(9986, new Solution2().maximumSwap(9986));
    }
}
