package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dijkstra {
	HashMap<GraphNode, ShortestPath> paths;
	Graph graph;

	public Dijkstra() {
		graph = new Graph();
		paths = new HashMap<GraphNode, ShortestPath>();
		createGraph();
	}

	private void createGraph() {
		graph = new Graph();
		for (int i = 1; i <= 10; i++) {
			graph.addNode("N" + i);
		}

		graph.connectNodes("N1", "N2", 2);
		graph.connectNodes("N1", "N3", 4);
		graph.connectNodes("N2", "N3", 1);
		graph.connectNodes("N2", "N4", 3);
		graph.connectNodes("N2", "N5", 2);
		graph.connectNodes("N4", "N6", 3);
		graph.connectNodes("N5", "N6", 2);
		graph.connectNodes("N5", "N7", 2);
		graph.connectNodes("N6", "N7", 1);
		graph.connectNodes("N6", "N9", 2);
		graph.connectNodes("N7", "N9", 4);
		graph.connectNodes("N7", "N8", 4);
		graph.connectNodes("N8", "N9", 3);
		graph.connectNodes("N8", "N10", 2);
		graph.connectNodes("N9", "N10", 1);
	}

	public void calculateShortestPaths(String sourceNodeName) {
		GraphNode source = graph.nodeMap.get(sourceNodeName);

		for (GraphNode node : graph.nodeMap.values()) {
			paths.put(node, new ShortestPath(Integer.MAX_VALUE, null));
		}
		paths.get(source).distance = 0;

		List<GraphNode> toBeProcessed = new ArrayList<GraphNode>();
		toBeProcessed.add(source);

		while (!toBeProcessed.isEmpty()) {
			GraphNode currentNode = toBeProcessed.remove(0);

			for (GraphNode neighbor : currentNode.neighbors.keySet()) {
				int newDistance = paths.get(currentNode).distance
						+ currentNode.neighbors.get(neighbor);
				if (newDistance < paths.get(neighbor).distance) {
					paths.get(neighbor).distance = newDistance;
					paths.get(neighbor).fromNode = currentNode;
					toBeProcessed.add(neighbor);
				}
			}
		}
		printAllShortestPaths(source);
	}

	private void printAllShortestPaths(GraphNode source) {
		for (GraphNode node : graph.nodeMap.values()) {
			GraphNode currentNode = node;
			String pathStr = "";
			do {
				pathStr = currentNode + " " + pathStr;
				currentNode = paths.get(currentNode).fromNode;
			} while (currentNode != null);
			System.out.println(pathStr);
		}
	}

	public static void main(String args[]) {
		Dijkstra dijkstra = new Dijkstra();
		dijkstra.calculateShortestPaths("N1");
		dijkstra.calculateShortestPaths("N5");
	}
}

class ShortestPath {
	int distance;
	GraphNode fromNode;

	public ShortestPath(int distance, GraphNode fromNode) {
		this.distance = distance;
		this.fromNode = fromNode;
	}
}