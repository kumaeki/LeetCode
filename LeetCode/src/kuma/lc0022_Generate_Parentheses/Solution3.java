package kuma.lc0022_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        helper(list, "", 0, 0, n);
        return list;
    }

    public void helper(List<String> list, String str, int left, int right, int n) {
        if (left + right == n * 2)
            list.add(str);
        else {
            if (left < n)
                helper(list, str + "(", left + 1, right, n);
            if (right < left)
                helper(list, str + ")", left, right + 1, n);
        }
    }
}
