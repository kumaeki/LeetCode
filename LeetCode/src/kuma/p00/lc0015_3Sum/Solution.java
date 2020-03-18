package kuma.p00.lc0015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    int[] arr;

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> reslist = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (len < 3)
            return reslist;

        arr = nums;
        Arrays.sort(arr);

        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && arr[i - 1] == arr[i])
                continue;
            for (int j = i + 1; j < len - 1; j++) {
                if (j > i + 1 && arr[j - 1] == arr[j])
                    continue;
                int target = 0 - arr[i] - arr[j];
                int index = getIndex(target, j + 1, len - 1);
                if (index > 0)
                    reslist.add(new ArrayList<Integer>(Arrays.asList(new Integer[] { arr[i], arr[j], target })));
                else if (-index == j + 2)
                    break;
            }
        }
        return reslist;
    }

    private int getIndex(int target, int left, int right) {
        if (left > right)
            return -left - 1;

        int mid = (left + right) / 2;
        if (arr[mid] > target)
            return getIndex(target, left, mid - 1);
        else if (arr[mid] < target)
            return getIndex(target, mid + 1, right);
        else
            return mid;
    }

}
