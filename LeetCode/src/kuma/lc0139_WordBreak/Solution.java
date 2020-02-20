package kuma.lc0139_WordBreak;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> wordSet = new HashSet<String>(len);
        Set<Integer> lenSet = new HashSet<Integer>(len);
        int[] arr = new int[len];

        for (String word : wordDict) {
            wordSet.add(word);
            lenSet.add(word.length());
        }

        for (int i = 0; i < len; i++) {
            if (i == 0 || arr[i - 1] == 1) {
                for (int wordlen : lenSet) {
                    int right = i + wordlen;
                    if (right <= len && arr[right - 1] != 1 && wordSet.contains(s.substring(i, right)))
                        arr[right - 1] = 1;
                }
            }
        }
        return arr[len - 1] == 1;
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        int len = s.length();
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            if (i == 0 || arr[i - 1] == 1) {
                for (String word : wordDict) {
                    int right = i + word.length();
                    if (right <= len && arr[right - 1] != 1 && s.substring(i, right).equals(word))
                        arr[right - 1] = 1;
                }
            }
        }
        return arr[len - 1] == 1;
    }

    @Test
    public void TestSimple1() {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<String>(Arrays.asList(new String[] { "leet", "code" }));
        assertEquals(true, new Solution().wordBreak(s, wordDict));
    }

    @Test
    public void TestSimple2() {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<String>(Arrays.asList(new String[] { "apple", "pen" }));
        assertEquals(true, new Solution().wordBreak(s, wordDict));
    }

    @Test
    public void TestSimple3() {
        String s = "catsandog";
        List<String> wordDict = new ArrayList<String>(
                Arrays.asList(new String[] { "cats", "dog", "sand", "and", "cat" }));
        assertEquals(false, new Solution().wordBreak(s, wordDict));
    }
}
