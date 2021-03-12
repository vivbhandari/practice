package bst;

import java.util.HashMap;

public class TreesDiff {
	public static HashMap<BSTNode, String> getTreeDiff(BSTNode one,
			BSTNode two) {
		HashMap<BSTNode, String> result = new HashMap<>();
		helper(one, two, result);
		return result;
	}

	public static void helper(BSTNode one, BSTNode two,
			HashMap<BSTNode, String> result) {
		if (one != null && two != null) {
			if(one.value != two.value)
				result.put(one, "Changed");
			helper(one.leftChild, two.leftChild, result);
			helper(one.rightChild, two.rightChild, result);
		} else if (one != null) {
			preOrder(one, "Delete", result);
		} else if (two != null) {
			preOrder(two, "Add", result);
		}
	}

	public static void preOrder(BSTNode root, String action,
			HashMap<BSTNode, String> result) {
		if (root != null) {
			result.put(root, action);
			preOrder(root.leftChild, action, result);
			preOrder(root.rightChild, action, result);
		}
	}

	public static BSTNode getTreeOne() {
		return new BSTNode(1, new BSTNode(2, new BSTNode(4), new BSTNode(5)),
				new BSTNode(3, new BSTNode(6), null));
	}

	public static BSTNode getTreeTwo() {
		return new BSTNode(1,
				new BSTNode(2, null, new BSTNode(5, new BSTNode(8), null)),
				new BSTNode(9, null, new BSTNode(7)));
	}

	public static void main(String args[]) {
		HashMap<BSTNode, String> result = getTreeDiff(getTreeOne(),
				getTreeTwo());
		for (BSTNode node : result.keySet()) {
			System.out.println(result.get(node) + " " + node.value);
		}
	}
}
