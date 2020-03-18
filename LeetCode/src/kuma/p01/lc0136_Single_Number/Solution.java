package kuma.p01.lc0136_Single_Number;

public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums)
            res ^= num;
        return res;
    }

}
