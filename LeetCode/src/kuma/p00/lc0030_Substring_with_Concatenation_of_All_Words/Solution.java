package kuma.p00.lc0030_Substring_with_Concatenation_of_All_Words;

import java.util.*;

class Solution {
    // Runtime: 64 ms, faster than 75.08% of Java online submissions for Substring
    // with Concatenation of All Words.
    // Memory Usage: 40.3 MB, less than 52.38% of Java online submissions for
    // Substring with Concatenation of All Words.
    int wordSize;
    int sum;

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return res;

        wordSize = words[0].length();
        int slen = s.length(), wordsLen = words.length;
        sum = wordsLen * wordSize;
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        for (int i = 0; i < wordsLen; i++) {
            String word = words[i];
            List<Integer> list = map.getOrDefault(word, new ArrayList<Integer>());
            list.add(i);
            map.put(word, list);
        }

        for (int i = 0, right = slen - sum; i <= right; i++)
            helper(s, i, map, words, new int[wordsLen], wordsLen, res);
        return res;
    }

    private void helper(String s, int index, Map<String, List<Integer>> map, String[] words, int[] visited, int remain,
            List<Integer> list) {
        if (remain == 0) {
            list.add(index - sum);
        } else {
            String key = s.substring(index, index + wordSize);
            List<Integer> temp = map.getOrDefault(key, new ArrayList<Integer>());
            if (temp.isEmpty())
                return;
            int wordLocation = temp.remove(0);
            if (visited[wordLocation] == 0)
                helper(s, index + wordSize, map, words, visited, remain - 1, list);
            temp.add(wordLocation);
        }
    }

    public static void main(String[] args) {
        new Solution().findSubstring("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "good" })
                .forEach(x -> System.out.print(x + ","));
        System.out.println("");
        System.out.println("");
        System.out.println("---");

        new Solution().findSubstring("barfoothefoobarman", new String[] { "foo", "bar" })
                .forEach(x -> System.out.print(x + ","));
        System.out.println("");
        System.out.println("---");

        new Solution().findSubstring("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "word" })
                .forEach(x -> System.out.print(x + ","));
        System.out.println("");
        System.out.println("---");

        new Solution().findSubstring("wordgoodgoodgoodbestword", new String[] { "good", "good" })
                .forEach(x -> System.out.print(x + ","));

    }
}
