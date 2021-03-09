package graph;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        return clone(node, map);
    }

    private Node clone(Node node, Map<Node, Node> map) {
        if (!map.containsKey(node)) {
            Node newNode = new Node(node.val);
            map.put(node, newNode);
            for (Node e: node.neighbors) {
                newNode.neighbors.add(clone(e, map));
            }
        }
        return map.get(node);
    }
}
