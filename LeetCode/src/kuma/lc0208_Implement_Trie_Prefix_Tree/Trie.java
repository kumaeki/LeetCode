package kuma.lc0208_Implement_Trie_Prefix_Tree;

import java.util.*;

class Trie {

    TreeNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode('*');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode node = root;
        for (char c : word.toCharArray()) {
            TreeNode next = node.add(c);
            node = next;
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode node = root;
        for (char c : word.toCharArray()) {
            TreeNode next = node.next[c - 'a'];
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
            TreeNode next = node.next[c - 'a'];
            if (next == null)
                return false;
            node = next;
        }
        return true;
    }

    class TreeNode {
        char ch;
        TreeNode[] next;
        boolean isEnd;

        public TreeNode(char ch) {
            this.ch = ch;
            next = new TreeNode[26];
        }

        public TreeNode add(char ch) {
            if (next[ch - 'a'] == null) {
                TreeNode node = new TreeNode(ch);
                next[ch - 'a'] = node;
            }
            return next[ch - 'a'];
        }

    }
}