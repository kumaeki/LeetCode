package kuma.p07.lc0739_Daily_Temperatures;

public class Solution {
    // Runtime: 713 ms, faster than 10.81%
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j < len; j++)
                if (T[i] < T[j]) {
                    res[i] = j - i;
                    break;
                }
        return res;
    }
}
