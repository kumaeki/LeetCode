package kuma.p04.lc0495_Teemo_Attacking;

public class Solution {
    // Runtime: 2 ms, faster than 52.11% of Java online submissions for Teemo
    // Attacking.
    // Memory Usage: 42.7 MB, less than 11.11% of Java online submissions for Teemo
    // Attacking.
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int len = timeSeries.length;
        if (len == 0 || duration == 0)
            return 0;

        int res = duration, endPre, startCur;
        for (int i = 1; i < len; i++) {
            endPre = timeSeries[i - 1] + duration - 1;
            startCur = timeSeries[i];
            if (endPre < startCur)
                res += duration;
            else if (endPre == startCur)
                res += (duration - 1);
            else
                res += (startCur - timeSeries[i - 1]);
        }

        return res;
    }
}
