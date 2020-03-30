package kuma.p01.lc0167_Two_Sum_II_Input_array_is_sorted;

import java.util.*;

public class Solution2 {
    // Runtime: 1 ms, faster than 45.86%
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (map.containsKey(target - num))
                return new int[] { map.get(target - num), i };
            else
                map.put(num, i);
        }
        return null;
    }
}
