package kuma.p01.lc0117_Populating_Next_Right_Pointers_in_Each_Node_II;

public class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Populating Next Right Pointers in Each Node II.
    // Memory Usage: 39.4 MB, less than 100.00% of Java online submissions for Populating Next Right Pointers in Each
    // Node II.
    public Node connect(Node root) {
        Node node = root;
        while (node != null) {
            Node head = new Node(-1);
            Node cur = head;
            while (node != null) {
                if (node.left != null) {
                    cur.next = node.left;
                    cur = cur.next;
                }
                if (node.right != null) {
                    cur.next = node.right;
                    cur = cur.next;
                }
                node = node.next;
            }
            node = head.next;
        }
        return root;
    }
}
