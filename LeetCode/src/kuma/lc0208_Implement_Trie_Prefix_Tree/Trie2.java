package kuma.lc0208_Implement_Trie_Prefix_Tree;

import java.util.*;

class Trie2 {

    TreeNode root;

    /** Initialize your data structure here. */
    public Trie2() {
        root = new TreeNode('*');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode node = root;
        for (char c : word.toCharArray()) {
            TreeNode next = node.next.get(c);
            if (next == null) {
                next = new TreeNode(c);
                node.next.put(c, next);
            }
            node = next;
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode node = root;
        for (char c : word.toCharArray()) {
            TreeNode next = node.next.get(c);
            if (next == null)
                return false;
            node = next;
        }
        return node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TreeNode node = root;
        for (char c : prefix.toCharArray()) {
            TreeNode next = node.next.get(c);
            if (next == null)
                return false;
            node = next;
        }
        return true;
    }

    class TreeNode {
        char ch;
        Map<Character, TreeNode> next;
        boolean isEnd;

        public TreeNode(char ch) {
            this.ch = ch;
            next = new HashMap<Character, TreeNode>();
        }

        public void addNext(char ch) {
            next.put(ch, new TreeNode(ch));
        }

        public boolean hasNext() {
            return !next.isEmpty();
        }
    }
}
