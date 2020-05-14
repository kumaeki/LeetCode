package kuma.p01.lc0151_Reverse_Words_in_a_String;

public class Solution2 {
    // Runtime: 1 ms, faster than 99.54% of Java online submissions for Reverse
    // Words in a String.
    // Memory Usage: 39.4 MB, less than 30.11% of Java online submissions for
    // Reverse Words in a String.
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ')
                continue;
            int j = i - 1;
            while (j >= 0 && s.charAt(j) != ' ')
                j--;
            sb.append(s.substring(j + 1, i + 1)).append(" ");
            i = j;
        }
        if (sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
