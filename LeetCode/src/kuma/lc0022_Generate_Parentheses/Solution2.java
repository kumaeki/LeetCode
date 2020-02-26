package kuma.lc0022_Generate_Parentheses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {

    public List<String> generateParenthesis(int n) {
        List<List<String>> list = new ArrayList<List<String>>(n + 1);
        list.add(Arrays.asList(new String[] { "" }));
        for (int i = 1; i <= n; i++) {
            List<String> nextl = new ArrayList<String>();
            for (int j = 0; j < i; j++)
                for (String left : list.get(j))
                    for (String right : list.get(i - j - 1))
                        nextl.add("(" + left + ")" + right);

            list.add(nextl);
        }
        return list.get(n);
    }

    public static void main(String[] args) {
        new Solution2().generateParenthesis(3);
    }
}
