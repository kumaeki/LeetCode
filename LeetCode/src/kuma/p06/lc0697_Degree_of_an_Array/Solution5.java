package kuma.p06.lc0697_Degree_of_an_Array;

public class Solution5 {
    // Runtime: 2 ms, faster than 100.00% of Java online submissions for Degree of
    // an Array.
    // Memory Usage: 42.9 MB, less than 16.67% of Java online submissions for Degree
    // of an Array.

    public int findShortestSubArray(int[] nums) {
        // get the max value of nums
        int max = 0;
        for (int num : nums)
            if (num > max)
                max = num;
        // count : frequency of num
        // fp : the position of first occur
        int[] count = new int[max + 1], fp = new int[max + 1];
        int degree = 1, res = 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            count[num]++;
            if (count[num] == 1)
                fp[num] = i;

            if (count[num] > degree) {
                degree = count[num];
                res = i - fp[num] + 1;
            } else if (count[num] == degree)
                res = Math.min(res, i - fp[num] + 1);
        }
        return res;
    }
}
