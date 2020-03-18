package kuma.p12.lc1262_Greatest_Sum_Divisible_by_Three;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] list1 = new int[2], list2 = new int[2];
        int res = 0, index1 = 0, index2 = 0;
        int remainder;
        Arrays.sort(nums);
        for (int num : nums) {
            res += num;
            remainder = num % 3;
            if (remainder == 1 && index1 < 2)
                list1[index1++] = num;
            else if (remainder == 2 && index2 < 2)
                list2[index2++] = num;
        }

        if (res % 3 == 0)
            return res;

        int can1 = Integer.MAX_VALUE;
        int can2 = Integer.MAX_VALUE;
        if (res % 3 == 1) {
            if (list1[0] > 0)
                can1 = list1[0];
            if (list2[0] > 0 && list2[1] > 0)
                can2 = list2[0] + list2[0];
            res -= Math.min(can1, can2);
        } else {
            if (list2[0] > 0)
                can2 = list2[0];
            if (list1[0] > 0 && list1[1] > 0)
                can1 = list1[1] + list1[1];
            res -= Math.min(can1, can2);
        }
        return res;
    }

    @Test
    public void testSimple1() {
        int actual = new Solution().maxSumDivThree(new int[] { 3, 6, 5, 1, 8 });
        int expected = 18;
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple2() {
        int actual = new Solution().maxSumDivThree(new int[] { 4 });
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple3() {
        int actual = new Solution().maxSumDivThree(new int[] { 1, 2, 3, 4, 4 });
        int expected = 12;
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple4() {
        int actual = new Solution().maxSumDivThree(new int[] { 2, 6, 2, 2, 7 });
        int expected = 15;
        assertEquals(expected, actual);
    }
}
