package kuma.p04.lc0485_Max_Consecutive_Ones;

public class Solution {
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Max
    // Consecutive Ones.
    // Memory Usage: 41.5 MB, less than 5.88% of Java online submissions for Max
    // Consecutive Ones.
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;
        for (int num : nums)
            if (num == 1)
                count++;
            else {
                max = Math.max(max, count);
                count = 0;
            }
        return Math.max(count, max);
    }
}
