package kuma.p04.lc0414_Third_Maximum_Number;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class Solution3 {
    // Runtime: 1 ms, faster than 88.94% of Java online submissions for Third
    // Maximum Number.
    // Memory Usage: 39.2 MB, less than 86.96% of Java online submissions for Third
    // Maximum Number.
    public int thirdMax3(int[] nums) {
        int len = nums.length, first = nums[0];
        for (int i = 1; i < len; i++)
            if (nums[i] > first)
                first = nums[i];

        Integer second = null;
        for (int i = 0; i < len; i++)
            if (nums[i] < first && (second == null || nums[i] > second))
                second = nums[i];

        Integer third = null;
        for (int i = 0; i < len; i++)
            if (second != null && nums[i] < second && (third == null || nums[i] > third))
                third = nums[i];

        return third == null ? first : third;
    }

    // Runtime: 2 ms, faster than 70.33% of Java online submissions for Third
    // Maximum Number.
    // Memory Usage: 39.6 MB, less than 73.91% of Java online submissions for Third
    // Maximum Number.
    public int thirdMax2(int[] nums) {
        Integer fst = null, sec = null, thd = null;
        for (Integer num : nums) {
            if (num.equals(fst) || num.equals(sec) || num.equals(thd))
                continue;
            if (fst == null || num.compareTo(fst) > 0) {
                thd = sec;
                sec = fst;
                fst = num;
            } else if (sec == null || num.compareTo(sec) > 0) {
                thd = sec;
                sec = num;
            } else if (thd == null || num.compareTo(thd) > 0)
                thd = num;
        }
        return thd == null ? fst : thd;
    }

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Third
    // Maximum Number.
    // Memory Usage: 39.4 MB, less than 82.61% of Java online submissions for Third
    // Maximum Number.
    public int thirdMax(int[] nums) {
        long fst = Long.MIN_VALUE, sec = Long.MIN_VALUE, thd = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > fst) {
                thd = sec;
                sec = fst;
                fst = num;
            } else if (num < fst && num > sec) {
                thd = sec;
                sec = num;
            } else if (num < sec && num > thd)
                thd = num;
        }
        return thd == Long.MIN_VALUE ? (int) fst : (int) thd;
    }

    @Test
    public void simple1() {
        assertEquals(1, new Solution3().thirdMax(new int[] { 1, 1 }));
    }

    @Test
    public void simple2() {
        assertEquals(1, new Solution3().thirdMax(new int[] { 3, 1, 2 }));
    }

    @Test
    public void simple3() {
        assertEquals(-2147483648, new Solution3().thirdMax(new int[] { 1, 2, -2147483648 }));
    }
}
