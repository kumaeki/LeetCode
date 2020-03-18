package kuma.p00.lc0072_Edit_Distance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

// to slow
class Solution2 {
    public int minDistance(String word1, String word2) {
        return helper(word1, word2, 0, 0);
    }

    private int helper(String word1, String word2, int index1, int index2) {
        int len1 = word1.length(), len2 = word2.length();
        if (index1 == len1)
            return len2 - index2;
        if (index2 == len2)
            return len1 - index1;
        char c1 = word1.charAt(index1), c2 = word2.charAt(index2);
        int res = helper(word1, word2, index1 + 1, index2 + 1) + (c1 == c2 ? 0 : 1);
        res = Math.min(res, helper(word1, word2, index1 + 1, index2) + 1);
        res = Math.min(res, helper(word1, word2, index1, index2 + 1) + 1);
        return res;
    }

    @Test
    public void simple1() {
        int expected = 3;
        String word1 = "horse";
        String word2 = "ros";
        int actual = new Solution2().minDistance(word1, word2);
        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        int expected = 5;
        String word1 = "intention";
        String word2 = "execution";
        int actual = new Solution2().minDistance(word1, word2);
        assertEquals(expected, actual);
    }

    @Test
    public void simple3() {
        int expected = 2;
        String word1 = "sea";
        String word2 = "eat";
        int actual = new Solution2().minDistance(word1, word2);
        assertEquals(expected, actual);
    }

    @Test
    public void simple4() {
        int expected = 2;
        String word1 = "eat";
        String word2 = "sea";
        int actual = new Solution2().minDistance(word1, word2);
        assertEquals(expected, actual);
    }
}
