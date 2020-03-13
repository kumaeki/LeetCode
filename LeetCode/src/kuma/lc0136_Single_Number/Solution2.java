package kuma.lc0136_Single_Number;

import java.util.*;

public class Solution2 {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (set.contains(num))
                set.remove(num);
            else
                set.add(num);
        }
        return set.iterator().next();
    }

    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            if (count < 1)
                map.put(num, 1);
            else
                map.remove(num);
        }
        return map.keySet().iterator().next();
    }

}
