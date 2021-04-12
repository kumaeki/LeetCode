package kuma.p00.lc0032_Longest_Valid_Parentheses;

public class Solution2 {
    public int longestValidParentheses(String s) {
        return Math.max(helper1(s), helper2(s));
    }

    private int helper1(String s) {
        int balance = 0, max = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                balance++;
            else
                balance--;
            if (balance >= 0) {
                count++;
                if (balance == 0)
                    max = Math.max(max, count);
            } else {
                count = 0;
                balance = 0;
            }
        }
        return max;
    }

    private int helper2(String s) {
        int balance = 0, max = 0, count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')')
                balance++;
            else
                balance--;
            if (balance >= 0) {
                count++;
                if (balance == 0)
                    max = Math.max(max, count);
            } else {
                count = 0;
                balance = 0;
            }
        }
        return max;
    }

}
