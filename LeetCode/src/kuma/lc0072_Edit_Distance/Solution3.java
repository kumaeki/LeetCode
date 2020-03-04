package kuma.lc0072_Edit_Distance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


// to slow
class Solution3 {
    public int minDistance(String word1, String word2) {
        if (word1.isEmpty())
            return word2.length();
        if (word2.isEmpty())
            return word1.length();
        char c1 = word1.charAt(0), c2 = word2.charAt(0);
        String nextWord1 = word1.substring(1);
        String nextWord2 = word2.substring(1);
        int res = minDistance(nextWord1, nextWord2) + (c1 == c2 ? 0 : 1);
        res = Math.min(res, minDistance(nextWord1, word2) + 1);
        res = Math.min(res, minDistance(word1, nextWord2) + 1);
        return res;
    }

    @Test
    public void simple1() {
        int expected = 3;
        String word1 = "horse";
        String word2 = "ros";
        int actual = new Solution3().minDistance(word1, word2);
        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        int expected = 5;
        String word1 = "intention";
        String word2 = "execution";
        int actual = new Solution3().minDistance(word1, word2);
        assertEquals(expected, actual);
    }

    @Test
    public void simple3() {
        int expected = 2;
        String word1 = "sea";
        String word2 = "eat";
        int actual = new Solution3().minDistance(word1, word2);
        assertEquals(expected, actual);
    }

    @Test
    public void simple4() {
        int expected = 2;
        String word1 = "eat";
        String word2 = "sea";
        int actual = new Solution3().minDistance(word1, word2);
        assertEquals(expected, actual);
    }
}
