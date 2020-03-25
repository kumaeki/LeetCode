package kuma.p04.lc0448_Find_All_Numbers_Disappeared_in_an_Array;

import java.util.*;

public class Solution {
    // Runtime: 5 ms, faster than 82.47%
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length, next;
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0)
                next = -nums[i] - 1;
            else
                next = nums[i] - 1;
            if (nums[next] > 0)
                nums[next] = -nums[next];
        }

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++)
            if (nums[i] > 0)
                list.add(i + 1);

        return list;
    }
}
