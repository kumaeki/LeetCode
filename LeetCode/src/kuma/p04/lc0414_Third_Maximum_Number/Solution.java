package kuma.p04.lc0414_Third_Maximum_Number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.Test;

public class Solution {
    // Runtime: 3 ms, faster than 47.57% of Java online submissions for Third
    // Maximum Number.
    // Memory Usage: 39.8 MB, less than 43.48% of Java online submissions for Third
    // Maximum Number.
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums)
            set.add(num);
        int len = set.size();
        Iterator<Integer> ite = set.iterator();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++)
            arr[i] = ite.next();
        if (len == 1)
            return arr[0];
        if (len == 2)
            return arr[0] > arr[1] ? arr[0] : arr[1];
        else
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < len - 1 - i; j++)
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
        return arr[len - 3];
    }

    @Test
    public void simple1() {
        assertEquals(1, new Solution().thirdMax(new int[] { 1, 1 }));
    }

    @Test
    public void simple2() {
        assertEquals(1, new Solution().thirdMax(new int[] { 3, 1, 2 }));
    }
}
