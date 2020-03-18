package kuma.p00.lc0078_Subsets;

import java.util.*;

public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        int start = (int) Math.pow(2, len), end = (int) Math.pow(2, len + 1);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = start; i < end; i++) {
            String bitmap = Integer.toBinaryString(i).substring(1);
            List<Integer> cur = new ArrayList<Integer>();
            for (int j = 0; j < bitmap.length(); j++)
                if (bitmap.charAt(j) == '1')
                    cur.add(nums[j]);
            res.add(cur);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(8));
    }
}
