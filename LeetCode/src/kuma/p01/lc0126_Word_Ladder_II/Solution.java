package kuma.p01.lc0126_Word_Ladder_II;

import java.util.*;

public class Solution {
    // Time Limit Exceeded
    List<List<Integer>> routes;
    int n;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        n = wordList.size();
        routes = new ArrayList<List<Integer>>(n + 1);
        for (int i = 0; i <= n; i++)
            routes.add(new ArrayList<Integer>());

        int target = -1;
        for (int i = 0; i < n; i++) {
            String word = wordList.get(i);
            // the beginning points
            if (check(word, beginWord) == 1)
                routes.get(n).add(i);
            // the stop point
            if (word.equals(endWord))
                target = i;
            for (int j = i + 1; j < n; j++) {
                if (check(word, wordList.get(j)) == 1) {
                    routes.get(i).add(j);
                    routes.get(j).add(i);
                }
            }
        }
        List<List<String>> res = new ArrayList<List<String>>();
        if (routes.get(n).size() == 0 || target == -1)
            return res;

        List<List<Integer>> resInt = new ArrayList<List<Integer>>();
        helper(resInt, new ArrayList<Integer>(), new HashSet<Integer>(), n, target);

        for (List<Integer> listInt : resInt) {
            if (listInt.size() > n)
                continue;
            List<String> listStr = new ArrayList<String>();
            listStr.add(beginWord);
            for (int i : listInt)
                listStr.add(wordList.get(i));
            res.add(listStr);
        }
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, Set<Integer> isVisited, int index, int target) {
        if (list.size() > n || routes.get(index).isEmpty())
            return;
        for (int i : routes.get(index)) {
            if (i == target && list.size() < n) {
                list.add(i);
                n = Math.min(n, list.size());
                res.add(new ArrayList<Integer>(list));
                list.remove(list.size() - 1);
            } else if (!isVisited.contains(i)) {
                isVisited.add(i);
                list.add(i);
                helper(res, list, isVisited, i, target);
                isVisited.remove(i);
                list.remove(list.size() - 1);
            }
        }
    }

    // 0: same , 1:one letter different, 2:more than one letter different
    private int check(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                count++;
            if (count > 1)
                break;
        }
        return count;
    }

    public static void main(String[] args) {
        String b = "a";
        String e = "c";
        String[] w = new String[] { "a", "b", "c", "d", "e", "f" };

//        String b = "hit";
//        String e = "cog";
//        String[] w = new String[] { "hot", "dot", "dog", "lot", "log", "cog" };
        
        List<List<String>> res = new Solution().findLadders(b, e, Arrays.asList(w));
        for (List<String> list : res) {
            list.forEach(x -> System.out.print(x + ","));
            System.out.println("");
        }

    }
}
