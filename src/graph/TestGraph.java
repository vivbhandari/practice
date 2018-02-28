package graph;

import java.util.ArrayList;
import java.util.List;

public class TestGraph {

	private static void calculateDFSOrderRecurse(Graph graph,
			String currentNodeValue, List<String> dfsOrder) {
		dfsOrder.add(currentNodeValue);
		for (GraphNode neighbor : graph.nodeMap.get(currentNodeValue).neighbors
				.keySet()) {
			if (!dfsOrder.contains(neighbor.value)) {
				calculateDFSOrderRecurse(graph, neighbor.value, dfsOrder);
			}
		}
	}

	public static List<String> getDFSOrderRecurse(Graph graph,
			String startNode) {
		List<String> dfsOrder = new ArrayList<String>();
		calculateDFSOrderRecurse(graph, startNode, dfsOrder);
		return dfsOrder;
	}

	public static List<String> getDFSOrder(Graph graph, String startNode) {
		List<String> dfsOrder = new ArrayList<String>();
		List<String> toBeProcessed = new ArrayList<String>();

		toBeProcessed.add(startNode);

		while (!toBeProcessed.isEmpty()) {
			String currentNodeValue = toBeProcessed.remove(0);
			if (!dfsOrder.contains(currentNodeValue)) {
				dfsOrder.add(currentNodeValue);

				int i = 0;
				for (GraphNode neighbor : graph.nodeMap
						.get(currentNodeValue).neighbors.keySet()) {
					if (!dfsOrder.contains(neighbor.value)) {
						toBeProcessed.add(i++, neighbor.value);
					}
				}
			}
		}

		return dfsOrder;
	}

	private static void calculateBFSOrderRecurse(Graph graph, int currentIndex,
			List<String> bfsOrder) {
		if (currentIndex < bfsOrder.size()) {
			String currentNodeValue = bfsOrder.get(currentIndex);
			for (GraphNode neighbor : graph.nodeMap
					.get(currentNodeValue).neighbors.keySet()) {
				if (!bfsOrder.contains(neighbor.value)) {
					bfsOrder.add(neighbor.value);
				}
			}
			calculateBFSOrderRecurse(graph, currentIndex + 1, bfsOrder);
		}
	}

	public static List<String> getBFSOrderRecurse(Graph graph,
			String startNode) {
		List<String> bfsOrder = new ArrayList<String>();
		bfsOrder.add(startNode);
		calculateBFSOrderRecurse(graph, 0, bfsOrder);
		return bfsOrder;
	}

	public static List<String> getBFSOrder(Graph graph, String startNode) {
		List<String> bfsOrder = new ArrayList<String>();
		List<String> toBeProcessed = new ArrayList<String>();

		toBeProcessed.add(startNode);

		while (!toBeProcessed.isEmpty()) {
			String currentNodeValue = toBeProcessed.remove(0);
			if (!bfsOrder.contains(currentNodeValue)) {
				bfsOrder.add(currentNodeValue);

				for (GraphNode neighbor : graph.nodeMap
						.get(currentNodeValue).neighbors.keySet()) {
					if (!bfsOrder.contains(neighbor.value)) {
						toBeProcessed.add(neighbor.value);
					}
				}
			}
		}

		return bfsOrder;
	}

	public static void main(String args[]) {
		Graph graph = new Graph();
		for (int i = 1; i <= 10; i++) {
			graph.addNode("N" + i);
		}

		graph.connectNodes("N1", "N2");
		graph.connectNodes("N1", "N3");
		graph.connectNodes("N2", "N3");
		graph.connectNodes("N2", "N4");
		graph.connectNodes("N3", "N5");
		graph.connectNodes("N3", "N6");
		graph.connectNodes("N4", "N5");
		graph.connectNodes("N4", "N7");
		graph.connectNodes("N4", "N9");
		graph.connectNodes("N5", "N7");
		graph.connectNodes("N5", "N6");
		graph.connectNodes("N6", "N8");
		graph.connectNodes("N7", "N8");
		graph.connectNodes("N8", "N9");
		graph.connectNodes("N8", "N10");
		graph.connectNodes("N9", "N10");

		System.out.println(graph);
		System.out.println("BFS order Iterative=" + getBFSOrder(graph, "N1"));
		System.out.println(
				"BFS order Recursive=" + getBFSOrderRecurse(graph, "N1"));

		System.out.println("BFS order Iterative=" + getBFSOrder(graph, "N10"));
		System.out.println(
				"BFS order Recursive=" + getBFSOrderRecurse(graph, "N10"));

		System.out.println("DFS order Iterative=" + getDFSOrder(graph, "N1"));
		System.out.println(
				"DFS order Recursive=" + getDFSOrderRecurse(graph, "N1"));

		System.out.println("DFS order Iterative=" + getDFSOrder(graph, "N3"));
		System.out.println(
				"DFS order Recursive=" + getDFSOrderRecurse(graph, "N3"));
	}
}
