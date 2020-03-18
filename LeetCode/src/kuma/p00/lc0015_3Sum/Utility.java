package kuma.p00.lc0015_3Sum;

import java.util.ArrayList;
import java.util.List;

public class Utility {
    public static List<List<Integer>> getList(int[][] arr) {
        List<List<Integer>> reslist = new ArrayList<List<Integer>>();
        for (int[] nums : arr) {
            List<Integer> list = new ArrayList<Integer>();
            for (int num : nums)
                list.add(num);

            reslist.add(list);
        }
        return reslist;
    }

}
