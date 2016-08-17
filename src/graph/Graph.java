package graph;

import java.util.HashMap;

public class Graph {

	HashMap<String, GraphNode> nodeMap = new HashMap<String, GraphNode>();

	public void addNode(String value) {
		GraphNode node = new GraphNode(value);
		nodeMap.put(value, node);
	}

	public void connectNodes(String node1, String node2) {
		GraphNode graphNode1 = nodeMap.get(node1);
		GraphNode graphNode2 = nodeMap.get(node2);
		graphNode1.neighbors.add(graphNode2);
		graphNode2.neighbors.add(graphNode1);
	}

	public void disconnectNodes(String node1, String node2) {
		GraphNode graphNode1 = nodeMap.get(node1);
		GraphNode graphNode2 = nodeMap.get(node2);
		graphNode1.neighbors.remove(graphNode2);
		graphNode2.neighbors.remove(graphNode1);
	}

	public void deleteNode(String value) {
		GraphNode removedNode = nodeMap.remove(value);
		for (GraphNode node : nodeMap.values()) {
			node.neighbors.remove(removedNode);
		}
	}

	@Override
	public String toString() {
		return "Graph [nodes=" + nodeMap.values() + "]";
	}
}
