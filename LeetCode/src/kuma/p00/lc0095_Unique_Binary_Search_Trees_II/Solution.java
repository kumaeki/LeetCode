package kuma.p00.lc0095_Unique_Binary_Search_Trees_II;

import java.util.*;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return n < 1 ? new ArrayList<TreeNode>() : generate(1, n);
    }

    private List<TreeNode> generate(int left, int right) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (left > right)
            res.add(null);
        else {
            for (int i = left; i <= right; i++) {
                List<TreeNode> listl = generate(left, i - 1);
                List<TreeNode> listr = generate(i + 1, right);
                for (TreeNode nodel : listl)
                    for (TreeNode noder : listr)
                        res.add(new TreeNode(i, nodel, noder));
            }
        }
        return res;
    }
}
