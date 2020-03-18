package kuma.p02.lc0239_Sliding_Window_Maximum;

import java.util.*;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return new int[] {};

        int len = nums.length;
        int[] res = new int[len - k + 1];
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < len; i++) {
            // remove the element out of range k
            while (!list.isEmpty() && list.getFirst() < i - k + 1)
                list.removeFirst();

            // remove the element smaller than nums[i] as they are useless 
            while (!list.isEmpty() && nums[list.getLast()] < nums[i])
                list.removeLast();

            // list -> index
            list.addLast(i);
            // res -> content
            if (i >= k - 1)
                res[i - k + 1] = nums[list.getFirst()];
        }
        return res;
    }
}
