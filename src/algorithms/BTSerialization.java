package algorithms;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class BTSerialization {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		return getPreOrder(root) + "/" + getInOrder(root);
	}

	private String getPreOrder(TreeNode root) {
		StringBuilder val = new StringBuilder();
		if (root != null) {
			val.append(root.val);
			if (root.left != null)
				val.append(",").append(getPreOrder(root.left));
			if (root.right != null)
				val.append(",").append(getPreOrder(root.right));
		}
		return val.toString();
	}

	private String getInOrder(TreeNode root) {
		StringBuilder val = new StringBuilder();
		if (root != null) {
			if (root.left != null)
				val.append(getInOrder(root.left)).append(",");
			val.append(root.val);
			if (root.right != null)
				val.append(",").append(getInOrder(root.right));
		}
		return val.toString();
	}

	private int search(String[] inOrder, int start, int end, String element) {
		for (int i = start; i <= end; i++) {
			if (inOrder[i].equals(element))
				return i;
		}
		return -1;
	}

	private TreeNode buildTree(String[] preOrder, String[] inOrder, int inStart,
			int inEnd) {
		if (inStart > inEnd)
			return null;

		String element = preOrder[preIndex++];
		TreeNode root = new TreeNode(Integer.parseInt(element));
		int inIndex = search(inOrder, inStart, inEnd, element);
		root.left = buildTree(preOrder, inOrder, inStart, inIndex - 1);
		root.right = buildTree(preOrder, inOrder, inIndex + 1, inEnd);
		return root;
	}

	int preIndex = 0;

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] orders = data.split("/");
		if (orders.length == 0)
			return null;
		preIndex = 0;
		String[] inOrder = orders[1].split(",");
		return buildTree(orders[0].split(","), inOrder, 0, inOrder.length - 1);
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		// root.right.right.left = new TreeNode(6);

		BTSerialization btSerialization = new BTSerialization();
		String serializedBT = btSerialization.serialize(null);
		System.out.println(serializedBT);
		serializedBT = btSerialization.serialize(root);
		System.out.println(serializedBT);
		TreeNode node = btSerialization.deserialize(serializedBT);
		System.out.println(btSerialization.getPreOrder(node));
		System.out.println(btSerialization.getInOrder(node));
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));