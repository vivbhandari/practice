package linkedlist;

public class LinkedNode {
	int value;
	LinkedNode nextNode;

	public LinkedNode(int value) {
		this(value, null);
	}

	public LinkedNode(int value, LinkedNode nextNode) {
		super();
		this.value = value;
		this.nextNode = nextNode;
	}

	@Override
	public String toString() {
		return value + "=>" + nextNode;
//		return "LinkedNode [value=" + value + ", nextNode=" + nextNode + "]";
	}
}
