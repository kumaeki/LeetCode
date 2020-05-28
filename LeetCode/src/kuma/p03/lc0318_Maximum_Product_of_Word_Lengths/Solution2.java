package kuma.p03.lc0318_Maximum_Product_of_Word_Lengths;

public class Solution2 {
    // Runtime: 6 ms, faster than 99.47% of Java online submissions for Maximum
    // Product of Word Lengths.
    // Memory Usage: 39.1 MB, less than 57.89% of Java online submissions for
    // Maximum Product of Word Lengths.
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int key = 0;
            for (char c : word.toCharArray())
                key |= (1 << (c - 'a'));
            arr[i] = key;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((arr[i] & arr[j]) == 0)
                    res = Math.max(res, words[i].length() * words[j].length());
            }
        }

        return res;
    }

}
