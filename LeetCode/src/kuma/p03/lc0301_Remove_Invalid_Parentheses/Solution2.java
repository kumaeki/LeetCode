package kuma.p03.lc0301_Remove_Invalid_Parentheses;

import java.util.*;

public class Solution2 {

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();
        helper(s, res, 0, 0, '(', ')');
        return res;
    }

    private void helper(String s, List<String> res, int prei, int prej, char paren1, char paren2) {
        int count = 0;
        int i = prei;
        while (i < s.length() && count >= 0) {
            char c = s.charAt(i++);
            if (c == paren1)
                count++;
            else if (c == paren2)
                count--;
        }

        if (count >= 0) {
            String reversed = new StringBuilder(s).reverse().toString();
            if (paren1 == '(')
                helper(reversed, res, 0, 0, paren2, paren1);
            else
                res.add(reversed);
        } else {
            i--;
            for (int j = prej; j <= i; j++) {
                if (s.charAt(j) == paren2 && (j == prej || s.charAt(j - 1) != paren2))
                    helper(s.substring(0, j) + s.substring(j + 1), res, i, j, paren1, paren2);
            }
        }

    }

    // hard to understand
    private void helper2(String s, List<String> res, int starti, int startj, char paren1, char paren2) {
        int count1 = 0, count2 = 0;
        for (int i = starti; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == paren1)
                count1++;
            else if (c == paren2)
                count2++;

            if (count2 > count1) {
                for (int j = startj; j <= i; j++) {
                    if (s.charAt(j) == paren2 && (j == startj || s.charAt(j - 1) != paren2)) {
                        helper(s.substring(0, j) + s.substring(j + 1), res, i, j, paren1, paren2);
                    }
                }
                return;
            }
        }

        String reversed = new StringBuilder(s).reverse().toString();
        if (paren1 == '(')
            helper(reversed, res, 0, 0, paren2, paren1);
        else
            res.add(reversed);
    }

}
