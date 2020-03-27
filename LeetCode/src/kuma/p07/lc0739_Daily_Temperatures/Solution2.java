package kuma.p07.lc0739_Daily_Temperatures;

import static org.junit.Assert.assertArrayEquals;
import java.util.*;

import org.junit.Test;

public class Solution2 {
    // Runtime: 713 ms, faster than 10.81%
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        List<Result> list = new ArrayList<Result>(len);
        for (int i = len - 1; i >= 0; i--) {
            Result r = new Result(T[i], i);
            int index = Collections.binarySearch(list, r, (r1, r2) -> (r1.val - r2.val));
            if (index < 0)
                index = -(index + 1);
            list.add(index++, r);
            if (index == list.size())
                res[i] = 0;
            else {
                int candidate = len;
                while (index < list.size()) {
                    Result temp = list.get(index++);
                    if (temp.val > T[i])
                        candidate = Math.min(candidate, temp.index);
                }

                res[i] = candidate == len ? 0 : candidate - i;
            }

        }
        return res;
    }

    class Result {
        int val;
        int index;

        public Result(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    @Test
    public void simple1() {
        int[] expecteds = new int[] { 1, 1, 4, 2, 1, 1, 0, 0 };
        int[] T = new int[] { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] actuals = new Solution2().dailyTemperatures(T);
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void simple2() {
        int[] expecteds = new int[] { 8, 1, 5, 4, 3, 2, 1, 1, 0, 0 };
        int[] T = new int[] { 89, 62, 70, 58, 47, 47, 46, 76, 100, 70 };
        int[] actuals = new Solution2().dailyTemperatures(T);
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void simple3() {
        int[] expecteds = new int[] { 1, 0, 0, 2, 1, 0, 0, 0, 0, 0 };
        int[] T = new int[] { 34, 80, 80, 34, 34, 80, 80, 80, 80, 34 };
        int[] actuals = new Solution2().dailyTemperatures(T);
        assertArrayEquals(expecteds, actuals);
    }
}
