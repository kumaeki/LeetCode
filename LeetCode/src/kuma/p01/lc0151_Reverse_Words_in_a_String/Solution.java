package kuma.p01.lc0151_Reverse_Words_in_a_String;

public class Solution {
    // Runtime: 1 ms, faster than 99.54% of Java online submissions for Reverse
    // Words in a String.
    // Memory Usage: 39.4 MB, less than 31.18% of Java online submissions for
    // Reverse Words in a String.
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--)
            if (!arr[i].isEmpty())
                sb.append(arr[i]).append(" ");

        return sb.toString().trim();

    }
}
