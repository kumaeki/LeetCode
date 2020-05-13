package kuma.p01.lc0137_Single_Number_II;

import java.util.*;

public class Solution3 {
    // Runtime: 3 ms, faster than 58.59% of Java online submissions for Single
    // Number II.
    // Memory Usage: 39.5 MB, less than 5.26% of Java online submissions for Single
    // Number II.
    public int singleNumber(int[] nums) {
        int res = 0, k = 3;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    count++;
                }
            }
            count %= k;
            if (count != 0)
                res |= (1 << i);
        }
        return res;
    }
}
