package bst;

public class Tree {

	BSTNode root;

	private void recurseAdd(BSTNode currentNode, BSTNode node) {
		if (node.value < currentNode.value) {
			if (currentNode.leftChild == null) {
				currentNode.leftChild = node;
			} else {
				recurseAdd(currentNode.leftChild, node);
			}
		} else {
			if (currentNode.rightChild == null) {
				currentNode.rightChild = node;
			} else {
				recurseAdd(currentNode.rightChild, node);
			}
		}
	}

	public void addNode(BSTNode node) {
		if (root == null) {
			root = node;
		} else {
			recurseAdd(root, node);
		}
	}

	public BSTNode getNode(int value) {
		BSTNode currentNode = root;
		BSTNode resultNode = null;
		while (currentNode != null) {
			if (currentNode.value == value) {
				resultNode = currentNode;
				break;
			} else if (value < currentNode.value) {
				currentNode = currentNode.leftChild;
			} else {
				currentNode = currentNode.rightChild;
			}
		}
		return resultNode;
	}

	public BSTNode deleteNode(int value) {
		BSTNode parentNode = null;
		BSTNode currentNode = root;
		BSTNode resultNode = null;
		while (currentNode != null) {
			if (currentNode.value == value) {
				resultNode = currentNode;

				if (currentNode.leftChild == null) {
					currentNode = currentNode.rightChild;
				} else if (currentNode.rightChild == null) {
					currentNode = currentNode.leftChild;
				} else {
					BSTNode curParentNode = currentNode;
					currentNode = currentNode.rightChild;
					while (currentNode.leftChild != null) {
						curParentNode = currentNode;
						currentNode = currentNode.leftChild;
					}
					curParentNode.leftChild = currentNode.rightChild;
					currentNode.leftChild = resultNode.leftChild;
					currentNode.rightChild = resultNode.rightChild;
				}

				if (parentNode == null) {
					root = currentNode;
				} else if (parentNode.value < value) {
					parentNode.rightChild = currentNode;
				} else {
					parentNode.leftChild = currentNode;
				}
				break;
			} else if (value < currentNode.value) {
				parentNode = currentNode;
				currentNode = currentNode.leftChild;
			} else {
				parentNode = currentNode;
				currentNode = currentNode.rightChild;
			}
		}
		return resultNode;
	}

	@Override
	public String toString() {
		return "Tree [root=" + root + "]";
	}
}
