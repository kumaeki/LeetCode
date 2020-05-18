package kuma.p02.lc0211_Add_and_Search_Word_Data_structure_design;

import java.util.*;

class WordDictionary {
    // Runtime: 48 ms, faster than 37.12% of Java online submissions for Add and
    // Search Word - Data structure design.
    // Memory Usage: 50 MB, less than 100.00% of Java online submissions for Add and
    // Search Word - Data structure design.
    TreeNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TreeNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TreeNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.next.containsKey(c)) {
                node.next.put(c, new TreeNode(c));
            }
            node = node.next.get(c);
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot
     * character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return helper(word.toCharArray(), 0, root);
    }

    private boolean helper(char[] arr, int index, TreeNode node) {
        if (index == arr.length)
            return node.isEnd;
        char c = arr[index];
        if (c == '.') {
            for (TreeNode next : node.next.values())
                if (helper(arr, index + 1, next))
                    return true;
            return false;
        } else if (node.next.containsKey(c))
            return helper(arr, index + 1, node.next.get(c));
        else
            return false;

    }

    class TreeNode {
        char val;
        boolean isEnd;
        Map<Character, TreeNode> next;

        public TreeNode() {
            this.next = new HashMap<Character, TreeNode>();
        }

        public TreeNode(char val) {
            this.val = val;
            this.next = new HashMap<Character, TreeNode>();
        }

    }

    public static void main(String[] args) {
        WordDictionary w = new WordDictionary();
        w.addWord("bad");
        w.addWord("dad");
        w.addWord("mad");
        System.out.println(w.search("pad"));
        System.out.println(w.search("bad"));
        System.out.println(w.search(".ad"));
        System.out.println(w.search("b.."));
    }
}
