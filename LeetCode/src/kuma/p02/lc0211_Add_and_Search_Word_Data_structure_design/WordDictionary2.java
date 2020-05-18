package kuma.p02.lc0211_Add_and_Search_Word_Data_structure_design;

class WordDictionary2 {
    // Runtime: 36 ms, faster than 92.40% of Java online submissions for Add and
    // Search Word - Data structure design.
    // Memory Usage: 51.1 MB, less than 100.00% of Java online submissions for Add
    // and Search Word - Data structure design.
    TreeNode root;

    /** Initialize your data structure here. */
    public WordDictionary2() {
        root = new TreeNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TreeNode node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TreeNode(c);
            }
            node = node.next[c - 'a'];
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
            for (TreeNode next : node.next)
                if (next != null && helper(arr, index + 1, next))
                    return true;
            return false;
        } else if (node.next[c - 'a'] != null)
            return helper(arr, index + 1, node.next[c - 'a']);
        else
            return false;

    }

    class TreeNode {
        char val;
        boolean isEnd;
        TreeNode[] next;

        public TreeNode() {
            this.next = new TreeNode[26];
        }

        public TreeNode(char val) {
            this.val = val;
            this.next = new TreeNode[26];
        }

    }

    public static void main(String[] args) {
        WordDictionary2 w = new WordDictionary2();
        w.addWord("bad");
        w.addWord("dad");
        w.addWord("mad");
        System.out.println(w.search("pad"));
        System.out.println(w.search("bad"));
        System.out.println(w.search(".ad"));
        System.out.println(w.search("b.."));
    }
}
