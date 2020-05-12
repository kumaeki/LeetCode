package kuma.p01.lc0133_Clone_Graph;

import java.util.*;

public class Solution {
    // Runtime: 27 ms, faster than 73.07% of Java online submissions for Clone
    // Graph.
    // Memory Usage: 39.5 MB, less than 5.88% of Java online submissions for Clone
    // Graph.
    public Node cloneGraph(Node node) {
        copyNode(node, new HashSet<Node>());
        copyNeighbors(node, new HashSet<Node>());
        return getCopy(node, new HashSet<Node>());
    }

    private void copyNode(Node node, Set<Node> set) {
        if (node == null || set.contains(node))
            return;
        set.add(node);
        Node copy = new Node(node.val, new ArrayList<Node>());
        List<Node> neighbors = node.neighbors;
        if (neighbors == null)
            neighbors = new ArrayList<Node>();
        neighbors.add(copy);
        for (int i = 0; i < neighbors.size() - 1; i++)
            copyNode(neighbors.get(i), set);
    }

    private void copyNeighbors(Node node, Set<Node> set) {
        if (node == null || set.contains(node))
            return;
        set.add(node);
        List<Node> neighbors = node.neighbors;
        Node copy = neighbors.get(neighbors.size() - 1);
        for (int i = 0; i < neighbors.size() - 1; i++) {
            Node next = neighbors.get(i);
            List<Node> list = next.neighbors;
            copy.neighbors.add(list.get(list.size() - 1));

            copyNeighbors(next, set);
        }
    }

    private Node getCopy(Node node, Set<Node> set) {
        if (node == null || set.contains(node))
            return node;
        set.add(node);
        List<Node> neighbors = node.neighbors;
        Node res = neighbors.remove(neighbors.size() - 1);
        for (Node next : neighbors) {
            getCopy(next, set);
        }
        return res;
    }
}
