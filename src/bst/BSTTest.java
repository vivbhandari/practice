package bst;

import java.util.Arrays;
import java.util.List;

public class BSTTest {

	public static NodeStats calculateStats(BSTNode root) {
		NodeStats nodeStats;
		if (root == null) {
			nodeStats = new NodeStats();
		} else {
			nodeStats = new NodeStats();
			NodeStats leftNodeStats = calculateStats(root.leftChild);
			NodeStats rightNodeStats = calculateStats(root.rightChild);
			nodeStats.height = 1
					+ Math.max(leftNodeStats.height, rightNodeStats.height);
			int myDiameter = 1 + leftNodeStats.height + rightNodeStats.height;
			nodeStats.diameter = Math.max(myDiameter,
					Math.max(leftNodeStats.diameter, rightNodeStats.diameter));
		}
		return nodeStats;
	}

	public static void main(String args[]) {
		Tree tree = new Tree();
		List<Integer> input = Arrays.asList(
				new Integer[] { 10, 5, 15, 3, 8, 12, 18, 2, 4, 6, 9, 7 });
		for (int i : input) {
			BSTNode node = new BSTNode(i);
			tree.addNode(node);
			System.out.println(tree);
		}

		System.out.println(calculateStats(tree.root));
		System.out.println(tree.getNode(10));
		System.out.println(tree.getNode(2));
		System.out.println(tree.getNode(18));
		System.out.println(tree.getNode(5));
		System.out.println(tree.deleteNode(5));
		System.out.println(tree);
		System.out.println(tree.getNode(6));
		System.out.println(tree.deleteNode(7));
		System.out.println(tree);
		System.out.println(tree.deleteNode(8));
		System.out.println(tree);
	}
}

class NodeStats {
	int height = 0;
	int diameter = 0;

	@Override
	public String toString() {
		return "NodeStats [height=" + height + ", diameter=" + diameter + "]";
	}
}
