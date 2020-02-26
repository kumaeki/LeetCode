package kuma.lc0022_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        return helper("", 0, 0, n);
    }

    public List<String> helper(String str, int left, int right, int n) {
        List<String> list = new ArrayList<String>();
        if (left + right == n * 2)
            list.add(str);
        else {
            if (left < n)
                list.addAll(helper(str + "(", left + 1, right, n));
            if (right < left)
                list.addAll(helper(str + ")", left, right + 1, n));
        }
        return list;
    }
}
