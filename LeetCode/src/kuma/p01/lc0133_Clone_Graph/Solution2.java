package kuma.p01.lc0133_Clone_Graph;

import java.util.*;

public class Solution2 {
    // Runtime: 26 ms, faster than 94.52% of Java online submissions for Clone
    // Graph.
    // Memory Usage: 39.9 MB, less than 5.88% of Java online submissions for Clone
    // Graph.
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<Node, Node>();
        copyNode(node, map);
        copyNeighbors(node, new HashSet<Node>(), map);
        return map.get(node);
    }

    private void copyNode(Node node, Map<Node, Node> map) {
        if (node == null || map.containsKey(node))
            return;
        Node copy = new Node(node.val, new ArrayList<Node>());
        map.put(node, copy);
        List<Node> neighbors = node.neighbors;
        if (neighbors == null)
            neighbors = new ArrayList<Node>();
        for (Node next : neighbors)
            copyNode(next, map);
    }

    private void copyNeighbors(Node node, Set<Node> set, Map<Node, Node> map) {
        if (node == null || set.contains(node))
            return;
        set.add(node);
        List<Node> neighbors = node.neighbors;
        Node copy = map.get(node);
        for (Node next : neighbors) {
            copy.neighbors.add(map.get(next));
            copyNeighbors(next, set, map);
        }
    }
}
