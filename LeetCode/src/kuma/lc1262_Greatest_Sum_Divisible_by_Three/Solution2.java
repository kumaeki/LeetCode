package kuma.lc1262_Greatest_Sum_Divisible_by_Three;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class Solution2 {
    public int maxSumDivThree(int[] nums) {
        int min1 = 10000, min2 = 10001, res = 0;
        int remainder;
        for (int num : nums) {
            res += num;
            remainder = num % 3;
            if (remainder == 1){
                min2 = Math.min(min2, min1 + num);
                min1 = Math.min(min1, num);
            } else if (remainder == 2){
                min1 = Math.min(min1, min2 + num);
                min2 = Math.min(min2, num);
            }
        }
        remainder = res % 3;
        if (remainder == 0)
            return res;
        else if (remainder == 1) 
            return res - min1;
        else 
            return res - min2;
    }

    @Test
    public void testSimple1() {
        int actual = new Solution2().maxSumDivThree(new int[] { 3, 6, 5, 1, 8 });
        int expected = 18;
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple2() {
        int actual = new Solution2().maxSumDivThree(new int[] { 4 });
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple3() {
        int actual = new Solution2().maxSumDivThree(new int[] { 1, 2, 3, 4, 4 });
        int expected = 12;
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple4() {
        int actual = new Solution2().maxSumDivThree(new int[] { 2, 6, 2, 2, 7 });
        int expected = 15;
        assertEquals(expected, actual);
    }
}
