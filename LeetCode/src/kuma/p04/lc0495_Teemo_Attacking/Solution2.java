package kuma.p04.lc0495_Teemo_Attacking;

public class Solution2 {
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Teemo
    // Attacking.
    // Memory Usage: 42.2 MB, less than 11.11% of Java online submissions for Teemo
    // Attacking.
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int len = timeSeries.length;
        if (len == 0 || duration == 0)
            return 0;

        int res = duration;
        for (int i = 1; i < len; i++)
            res += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);

        return res;
    }
}
