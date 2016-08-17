package bst;

public class BSTNode {

	int value;
	BSTNode leftChild;
	BSTNode rightChild;

	public BSTNode(int value) {
		this(value, null, null);
	}

	public BSTNode(int value, BSTNode leftChild, BSTNode rightChild) {
		super();
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		return "BSTNode [value=" + value + ", leftChild=" + leftChild
				+ ", rightChild=" + rightChild + "]";
	}
}
