package kuma.lc0046_Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res;
        if (nums == null || nums.length == 0) {
            res = new ArrayList<List<Integer>>();
            res.add(Arrays.asList(new Integer[] {}));
        } else {
            Queue<List<Integer>> que = new LinkedList<List<Integer>>();
            List<Integer> list = new ArrayList<Integer>();
            list.add(nums[nums.length - 1]);
            que.offer(list);
            for (int i = nums.length - 2; i >= 0; i--) {
                int size = que.size();
                while (size > 0) {
                    List<Integer> l = que.poll();
                    for (int j = 0, len = l.size(); j <= len; j++) {
                        List<Integer> newlist = new ArrayList<Integer>(l);
                        newlist.add(j, nums[i]);
                        que.offer(newlist);
                    }
                    size--;
                }
            }
            res = new ArrayList<List<Integer>>(que);
        }
        return res;
    }
}
