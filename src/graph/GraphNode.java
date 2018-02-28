package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphNode {

	String value;
	HashMap<GraphNode, Integer> neighbors;

	public GraphNode(String value) {
		this(value, new HashMap<GraphNode, Integer>());
	}

	public GraphNode(String value, HashMap<GraphNode, Integer> neighbors) {
		super();
		this.value = value;
		this.neighbors = neighbors;
	}

	private List<String> getNeighborValues() {
		List<String> neighborValues = new ArrayList<String>();
		for (GraphNode node : neighbors.keySet()) {
			neighborValues.add(node.value);
		}
		return neighborValues;
	}

	@Override
	public String toString() {
		return "GraphNode [value=" + value + ", neighbors="
				+ getNeighborValues() + "]";
	}
}
