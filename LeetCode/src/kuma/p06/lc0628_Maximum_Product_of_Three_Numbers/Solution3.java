package kuma.p06.lc0628_Maximum_Product_of_Three_Numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution3 {
    // Runtime: 7 ms, faster than 60.05% of Java online submissions for Maximum
    // Product of Three Numbers.
    // Memory Usage: 51.4 MB, less than 7.14% of Java online submissions for Maximum
    // Product of Three Numbers.
    public int maximumProduct(int[] nums) {
        int[] arr = new int[2001];
        for (int num : nums)
            arr[num + 1000]++;

        int left = 1, right = 1;
        int count = 2;
        Integer max = null;
        for (int i = 0; i < 2001; i++)
            for (int j = 0; j < arr[i] && count-- > 0; i++)
                left *= (i - 1000);

        count = 3;
        for (int i = 2000; i >= 0; i--)
            for (int j = 0; j < arr[i] && count-- > 0; j++) {
                right *= (i - 1000);
                if (max == null)
                    max = i - 1000;
            }

        return Math.max(left * max, right);
    }

    @Test
    public void simple1() {
        assertEquals(30, new Solution3().maximumProduct(new int[] { 1, 2, 3, 5 }));
    }
}
