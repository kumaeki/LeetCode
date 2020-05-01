package kuma.p00.lc0089_Gray_Code;

import java.util.*;

public class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Gray Code.
    // Memory Usage: 37.4 MB, less than 8.00% of Java online submissions for Gray
    // Code.
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        int k = 1;
        while (n-- > 0) {
            List<Integer> temp = new ArrayList<Integer>(res);
            for (int i = temp.size() - 1; i >= 0; i--)
                res.add(temp.get(i) + k);
            k *= 2;
        }
        return res;
    }
}
