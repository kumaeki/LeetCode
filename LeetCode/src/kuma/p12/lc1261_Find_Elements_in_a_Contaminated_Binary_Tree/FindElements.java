package kuma.p12.lc1261_Find_Elements_in_a_Contaminated_Binary_Tree;

import java.util.HashSet;
import java.util.Set;

class FindElements {

    TreeNode rootNode;
    Set<Integer> set;

    public FindElements(TreeNode root) {
        rootNode = root;
        set = new HashSet<Integer>();
        setVal(rootNode, 0);
    }

    private void setVal(TreeNode node, int val) {
        if (node != null) {
            node.val = val;
            set.add(val);
            int base = 2 * val;
            setVal(node.left, base + 1);
            setVal(node.right, base + 2);
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }

}
