package kuma.p04.lc0448_Find_All_Numbers_Disappeared_in_an_Array;

import java.util.*;

public class Solution3 {
    // Runtime: 5 ms, faster than 82.47%
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++)
            nums[(nums[i] - 1) % len] += len;

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++)
            if (nums[i] <= len)
                list.add(i + 1);

        return list;
    }
}
