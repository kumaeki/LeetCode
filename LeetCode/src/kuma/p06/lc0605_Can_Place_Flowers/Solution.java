package kuma.p06.lc0605_Can_Place_Flowers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution {
    // Runtime: 1 ms, faster than 96.08% of Java online submissions for Can Place
    // Flowers.
    // Memory Usage: 41.1 MB, less than 7.14% of Java online submissions for Can
    // Place Flowers.
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int index = 0, i = 0, count = 0;
        for (; i < len; i++) {
            if (flowerbed[i] == 1 || i == len - 1) {
                int dif = i - index - 1;
                if (index == 0)
                    dif++;
                if (i == len - 1 && flowerbed[i] == 0)
                    dif += 2;
                count += dif / 2;
                index = i + 1;
            }
        }
        return count >= n;
    }

    @Test
    public void simple1() {
        assertEquals(true, new Solution().canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 1));
    }

    @Test
    public void simple2() {
        assertEquals(false, new Solution().canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 2));
    }

    @Test
    public void simple3() {
        assertEquals(true, new Solution().canPlaceFlowers(new int[] { 1, 0, 0, 0, 0 }, 2));
    }

    @Test
    public void simple4() {
        assertEquals(false, new Solution().canPlaceFlowers(new int[] { 1, 0, 0, 0, 0 }, 3));
    }

    @Test
    public void simple5() {
        assertEquals(true, new Solution().canPlaceFlowers(new int[] { 0, 0, 0, 0, 0 }, 3));
    }

    @Test
    public void simple6() {
        assertEquals(true, new Solution().canPlaceFlowers(new int[] { 0, 0, 0, 0, 1 }, 2));
    }

    @Test
    public void simple7() {
        assertEquals(false, new Solution().canPlaceFlowers(new int[] { 0, 0, 0, 0, 1 }, 3));
    }
}
