package graph;

import java.util.HashMap;

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

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass())
			return false;
		GraphNode other = (GraphNode) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return value;
	}
}
