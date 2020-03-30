package kuma.p01.lc0169_Majority_Element;

public class Solution3 {
    // Runtime: 1 ms, faster than 99.86%
    public int majorityElement(int[] nums) {
        int count = 1, cand = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (count == 0)
                cand = num;
            count += (cand == num ? +1 : -1);
        }
        return cand;
    }
}
