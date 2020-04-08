package kuma.p06.lc0697_Degree_of_an_Array;

import java.util.*;

public class Solution3 {
    // Runtime: 16 ms, faster than 71.72% of Java online submissions for Degree of
    // an Array.
    // Memory Usage: 46.6 MB, less than 5.55% of Java online submissions for Degree
    // of an Array.

    public int findShortestSubArray(int[] nums) {
        int max = 0;
        for (int num : nums)
            if (num > max)
                max = num;

        int[][] arr = new int[max + 1][3];
        Arrays.fill(arr, new int[] { -1, -1, 0 });
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            int[] positions = arr[num];
            if (positions[0] == -1)
                positions[0] = i;
            positions[1] = i;
            positions[2]++;
        }
        int degree = 0, res = len;
        for (int[] positions : arr) {
            if (positions[2] > degree) {
                degree = positions[2];
                res = positions[1] - positions[0] + 1;
            } else if (positions[2] == degree)
                res = Math.min(res, res = positions[1] - positions[0] + 1);
        }
        return res;
    }
}
