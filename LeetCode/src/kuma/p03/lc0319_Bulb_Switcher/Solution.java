package kuma.p03.lc0319_Bulb_Switcher;

public class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Bulb
    // Switcher.
    // Memory Usage: 36 MB, less than 33.33% of Java online submissions for Bulb
    // Switcher.
    public int bulbSwitch(int n) {
        // return (int)Math.sqrt(n);
        return (int) getSqrt(n);
    }

    private long getSqrt(int n) {
        long left = 1, right = n;
        while (left <= right) {
            long mid = (left + right) / 2;
            long mul = mid * mid;
            if (mul == n)
                return mid;
            else if (mul > n)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return right;
    }
}
