package kuma.p03.lc0337_House_Robber_III;

import kuma.p03.TreeNode;
import java.util.*;

public class Solution3 {

    Map<TreeNode, Integer> mapRob, mapSkip;

    public int rob(TreeNode root) {
        mapRob = new HashMap<TreeNode, Integer>();
        mapSkip = new HashMap<TreeNode, Integer>();
        return Math.max(helper(root, false), helper(root, true));
    }

    public int helper(TreeNode node, boolean robbed) {
        if (node == null)
            return 0;
        // rob the house
        if (robbed) {
            if (!mapRob.containsKey(node))
                mapRob.put(node, node.val + helper(node.left, false) + helper(node.right, false));
            return mapRob.get(node);
        }
        // do not rob the house
        else {
            if (!mapSkip.containsKey(node))
                mapSkip.put(node, Math.max(helper(node.left, true), helper(node.left, false))
                        + Math.max(helper(node.right, true), helper(node.right, false)));
            return mapSkip.get(node);
        }
    }

}
