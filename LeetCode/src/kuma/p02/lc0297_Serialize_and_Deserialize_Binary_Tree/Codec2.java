package kuma.p02.lc0297_Serialize_and_Deserialize_Binary_Tree;

import java.util.*;

public class Codec2 {
    
    static String NULL = "n";
    static String COMMA = ",";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        TreeNode node;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);

        while (!que.isEmpty()) {
            node = que.poll();
            if (node == null)
                sb.append(NULL);
            else {
                sb.append(node.val);
                que.offer(node.left);
                que.offer(node.right);
            }
            sb.append(COMMA);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(COMMA);
        TreeNode root = null;
        if (arr[0].equals(NULL))
            return root;
        else
            root = new TreeNode(Integer.valueOf(arr[0]));
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        TreeNode node;
        for (int i = 1; i < arr.length; i++) {
            node = que.poll();
            String str = arr[i];
            if (!str.equals(NULL)) {
                TreeNode left = new TreeNode(Integer.valueOf(str));
                que.offer(left);
                node.left = left;
            }

            if (++i < arr.length) {
                str = arr[i];
                if (!str.equals(NULL)) {
                    TreeNode right = new TreeNode(Integer.valueOf(str));
                    que.offer(right);
                    node.right = right;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Codec2 c = new Codec2();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        n1.left = n2;
        String s = c.serialize(n1);
        c.deserialize(s);
    }
}
