package kuma.p03.lc0301_Remove_Invalid_Parentheses;

import java.util.*;

public class Solution {

    public List<String> removeInvalidParentheses(String s) {
        // needless left , needless right
        int nll = 0, nlr = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                nll++;
            else if (c == ')') {
                if (nll == 0)
                    nlr++;
                else
                    nll--;
            }
        }

        Set<String> set = new HashSet<String>();
        helper(s, 0, 0, 0, nll, nlr, new StringBuilder(), set);
        return new ArrayList<String>(set);
    }

    private void helper(String s, int index, int left, int right, int nll, int nlr, StringBuilder sb, Set<String> set) {
        if(nll + nlr > s.length() - index)
            return;
        else if (index == s.length()) {
            if (nll == 0 && nlr == 0)
                set.add(sb.toString());
        } else {
            char c = s.charAt(index);
            if ((c == '(') && nll > 0) {
                helper(s, index + 1, left, right, nll - 1, nlr, sb, set);
            } else if (c == ')' && nlr > 0) {
                helper(s, index + 1, left, right, nll, nlr - 1, sb, set);
            }

            sb.append(c);
            if (c != '(' && c != ')')
                helper(s, index + 1, left, right, nll, nlr, sb, set);
            else if (c == '(')
                helper(s, index + 1, left + 1, right, nll, nlr, sb, set);
            else if (left > right)
                helper(s, index + 1, left, right + 1, nll, nlr, sb, set);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
