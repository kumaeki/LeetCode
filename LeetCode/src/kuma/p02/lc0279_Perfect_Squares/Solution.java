package kuma.p02.lc0279_Perfect_Squares;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import java.util.*;

public class Solution {

    public static List<Integer> list = new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 1, 2, 3 }));

    public int numSquares(int n) {
        if (n <= list.size())
            return list.get(n);

        int sq, val, res;
        for (int i = list.size(); i < n + 1; i++) {
            res = i;
            sq = (int) Math.sqrt(i);
            for (int j = sq; j > 0; j--) {
                val = j * j;
                if (val == i) {
                    res = 1;
                    break;
                } else
                    res = Math.min(res, list.get(i - val) + list.get(val));
            }
            list.add(res);
        }
        return list.get(n);
    }

    @Test
    public void Simple2() {
        int expected = 3;
        int actual = new Solution().numSquares(12);
        assertEquals(expected, actual);
    }
}
