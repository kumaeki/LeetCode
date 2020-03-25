package kuma.p04.lc0448_Find_All_Numbers_Disappeared_in_an_Array;

import java.util.*;

public class Solution2 {
    // Runtime: 4 ms, faster than 90.07%
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int start = 1;
        while (start <= nums.length) {
            int next = nums[start - 1];
            while (nums[next - 1] != next) {
                int temp = nums[next - 1];
                nums[next - 1] = next;
                next = temp;
            }
            start++;
        }

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++)
            if (i + 1 != nums[i])
                list.add(i + 1);

        return list;
    }
}
