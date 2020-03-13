package kuma.lc0138_Copy_List_with_Random_Pointer;

import java.util.*;

public class Solution2 {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<Node, Node>();
        Node root = new Node(-1);
        Node pre = root;
        Node nodeold = head;
        while (nodeold != null) {
            Node nodenew = new Node(nodeold.val);
            pre.next = nodenew;
            map.put(nodeold, nodenew);
            nodeold = nodeold.next;
            pre = pre.next;
        }

        nodeold = head;
        while (nodeold != null) {
            Node nodenew = map.get(nodeold);
            if (nodeold.random != null)
                nodenew.random = map.get(nodeold.random);
            nodeold = nodeold.next;
        }

        return root.next;
    }
}
