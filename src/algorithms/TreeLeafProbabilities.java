package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TreeLeafProbabilities {
	static class Node {
		int value;
		List<Node> children;

		public Node(int value) {
			this.value = value;
			this.children = new ArrayList<>();
		}
	}

	private static Node createNewTree() {
		Node root = new Node(1);
		root.children.add(new Node(2));
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		node3.children.add(node4);
		Node node5 = new Node(5);
//		node4.children.add(node5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		node3.children.add(node7);
		node6.children.add(node7);
		node6.children.add(new Node(8));
		node5.children.add(node6);
		node3.children.add(node5);
		root.children.add(node3);
		return root;
	}

	public static HashMap<Integer, Double> getProbabilities(Node root) {
		HashMap<Integer, Double> probabilities = new HashMap<>();
		helper(root, probabilities, 1);
		return probabilities;
	}

	public static void helper(Node root, HashMap<Integer, Double> probabilities,
			double probSoFar) {
		if (root != null) {
			int childrenCount = root.children.size();
			if (childrenCount == 0) {
				probabilities.put(root.value,
						probabilities.getOrDefault(root.value, 0.0)
								+ probSoFar);
			} else {
				for (Node child : root.children) {
					helper(child, probabilities, probSoFar / childrenCount);
				}
			}
		}
	}

	public static void main(String args[]) {
		HashMap<Integer, Double> probabilities = getProbabilities(
				createNewTree());
		for (int key : probabilities.keySet()) {
			System.out.println(key + "=" + probabilities.get(key));
		}
	}
}
