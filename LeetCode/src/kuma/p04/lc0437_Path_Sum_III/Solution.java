package kuma.p04.lc0437_Path_Sum_III;

import kuma.p04.TreeNode;
import java.util.*;

public class Solution {
    // Runtime: 2 ms, faster than 100.00%
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        return helper(root, 0, sum, map);
    }

    private int helper(TreeNode node, int sumCur, int target, Map<Integer, Integer> map) {
        if (node == null)
            return 0;

        sumCur += node.val;
        int res = map.getOrDefault(sumCur - target, 0);
        map.put(sumCur, map.getOrDefault(sumCur, 0) + 1);
        res += (helper(node.left, sumCur, target, map) + helper(node.right, sumCur, target, map));
        map.put(sumCur, map.get(sumCur) - 1);
        return res;
    }
}
