package kuma.p09.lc0974_Subarray_Sums_Divisible_by_K;

import java.util.*;

public class Solution {
    // Runtime: 14 ms, faster than 60.04% of Java online submissions for Subarray
    // Sums Divisible by K.
    // Memory Usage: 46.2 MB, less than 5.26% of Java online submissions for
    // Subarray Sums Divisible by K.
    public int subarraysDivByK(int[] A, int K) {
        int res = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        for (int a : A) {
            sum = ((sum + a) % K + K) % K;
            int count = map.getOrDefault(sum, 0);
            res += count;
            map.put(sum, count + 1);
        }
        return res;
    }
}
