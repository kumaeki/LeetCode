package kuma.p01.lc0126_Word_Ladder_II;

import java.util.*;

public class Solution2 {
    // Runtime: 105 ms, faster than 62.31% of Java online submissions for Word
    // Ladder II.
    // Memory Usage: 47.2 MB, less than 67.31% of Java online submissions for Word
    // Ladder II.

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        Map<String, List<String>> graph = new HashMap<String, List<String>>(n);
        Map<String, Integer> levels = new HashMap<String, Integer>(n);

        generateGraph(beginWord, endWord, wordList, graph, levels);

        List<List<String>> res = new ArrayList<List<String>>();
        helper(beginWord, endWord, res, new ArrayList<String>(), graph, levels);

        return res;
    }

    private void generateGraph(String beginWord, String endWord, List<String> wordList, Map<String, List<String>> graph,
            Map<String, Integer> levels) {
        for (String word : wordList)
            graph.put(word, new ArrayList<String>());
        graph.put(beginWord, new ArrayList<String>());
        levels.put(beginWord, 0);
        boolean isFoundEnd = false;
        Set<String> set = new HashSet<String>();
        for (String word : wordList)
            set.add(word);
        Queue<String> que = new LinkedList<String>();
        que.add(beginWord);

        while (!que.isEmpty()) {
            String word = que.poll();
            int curLevel = levels.get(word);
            List<String> list = getNextList(set, word);
            for (String next : list) {
                graph.get(word).add(next);
                if (!levels.containsKey(next)) {
                    levels.put(next, curLevel + 1);
                    if (next == endWord)
                        isFoundEnd = true;
                    else
                        que.offer(next);
                }
            }
            if (isFoundEnd)
                return;
        }
    }

    private List<String> getNextList(Set<String> set, String word) {
        List<String> res = new ArrayList<String>();
        char[] arr = word.toCharArray();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < arr.length; i++) {
                if (c == arr[i])
                    continue;
                char temp = arr[i];
                arr[i] = c;
                String str = String.valueOf(arr);
                if (set.contains(str))
                    res.add(str);
                arr[i] = temp;
            }
        }
        return res;
    }

    private void helper(String beginWord, String endWord, List<List<String>> res, List<String> list,
            Map<String, List<String>> graph, Map<String, Integer> levels) {
        list.add(beginWord);
        if (beginWord.equals(endWord))
            res.add(new ArrayList<String>(list));
        else {
            int curLevel = levels.get(beginWord);
            for (String next : graph.get(beginWord)) {
                if (levels.get(next) == curLevel + 1)
                    helper(next, endWord, res, list, graph, levels);
            }
        }
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
//        String b = "a";
//        String e = "c";
//        String[] w = new String[] { "a", "b", "c", "d", "e", "f" };

        String b = "hit";
        String e = "cog";
        String[] w = new String[] { "hot", "dot", "dog", "lot", "log", "cog" };

        List<List<String>> res = new Solution2().findLadders(b, e, Arrays.asList(w));
        for (List<String> list : res) {
            list.forEach(x -> System.out.print(x + ","));
            System.out.println("");
        }

    }
}
