package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphNode {

	String value;
	Set<GraphNode> neighbors;

	public GraphNode(String value) {
		this(value, new HashSet<GraphNode>());
	}

	public GraphNode(String value, Set<GraphNode> neighbors) {
		super();
		this.value = value;
		this.neighbors = neighbors;
	}

	private List<String> getNeighborValues() {
		List<String> neighborValues = new ArrayList<String>();
		for (GraphNode node : neighbors) {
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
