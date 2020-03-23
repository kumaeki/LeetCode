package kuma.p02.lc0297_Serialize_and_Deserialize_Binary_Tree;

public class Codec {

    static String NULL = "n";
    static String COMMA = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helperS(root, sb);
        return sb.substring(0, sb.length() - 1);
    }

    private void helperS(TreeNode node, StringBuilder sb) {
        if (node == null)
            sb.append(NULL).append(COMMA);
        else {
            sb.append(node.val).append(COMMA);
            helperS(node.left, sb);
            helperS(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return helperD(data.split(COMMA), new int[] { 0 });
    }

    public TreeNode helperD(String[] arr, int[] index) {
        String cur = arr[index[0]++];
        if (cur.equals(NULL))
            return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(cur));
            index[0]++;
            node.left = helperD(arr, index);
            node.right = helperD(arr, index);
            return node;
        }
    }

    public static void main(String[] args) {
        Codec c = new Codec();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        n1.left = n2;
        String s = c.serialize(n1);
        c.deserialize(s);
    }
}
