package kuma.lc0072_Edit_Distance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dps = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len2; i++)
            dps[0][i] = i;
        for (int i = 0; i <= len1; i++)
            dps[i][0] = i;

        for (int i = 0; i < len1; i++)
            for (int j = 0; j < len2; j++) {
                if (word1.charAt(i) == word2.charAt(j))
                    dps[i + 1][j + 1] = dps[i][j];
                else {
                    dps[i + 1][j + 1] = getMin(dps[i][j + 1], dps[i + 1][j], dps[i][j]) + 1;
                }
            }
        return dps[len1][len2];
    }

    private int getMin(int i, int j, int k) {
        return Math.min(Math.min(i, j), k);
    }

    @Test
    public void simple1() {
        int expected = 3;
        String word1 = "horse";
        String word2 = "ros";
        int actual = new Solution().minDistance(word1, word2);
        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        int expected = 5;
        String word1 = "intention";
        String word2 = "execution";
        int actual = new Solution().minDistance(word1, word2);
        assertEquals(expected, actual);
    }

    @Test
    public void simple3() {
        int expected = 2;
        String word1 = "sea";
        String word2 = "eat";
        int actual = new Solution().minDistance(word1, word2);
        assertEquals(expected, actual);
    }

    @Test
    public void simple4() {
        int expected = 2;
        String word1 = "eat";
        String word2 = "sea";
        int actual = new Solution().minDistance(word1, word2);
        assertEquals(expected, actual);
    }

    @Test
    public void simple5() {
        int expected = 6;
        String word1 = "intention1";
        String word2 = "execution";
        int actual = new Solution().minDistance(word1, word2);
        assertEquals(expected, actual);
    }

    @Test
    public void simple6() {
        int expected = 10;
        String word1 = "zoologicoarchaeologist";
        String word2 = "zoogeologist";
        int actual = new Solution().minDistance(word1, word2);
        assertEquals(expected, actual);
    }

    @Test
    public void simple7() {
        int expected = 3;
        String word1 = "aabdbddcc";
        String word2 = "aabbcc";
        int actual = new Solution().minDistance(word1, word2);
        assertEquals(expected, actual);
    }

}
