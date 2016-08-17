package linkedlist;

public class LinkedList {

	LinkedNode head;

	public LinkedNode get(int index) {
		LinkedNode currentNode = head;
		int counter = 0;
		while (counter != index && currentNode != null) {
			currentNode = currentNode.nextNode;
			counter++;
		}
		return currentNode;
	}

	public void add(LinkedNode linkedNode, int position) {
		LinkedNode currentNode = head;
		if (position == 0 || head == null) {
			linkedNode.nextNode = head;
			head = linkedNode;
		} else {
			int counter = 0;
			while (currentNode.nextNode != null
					&& (position == -1 || counter != position - 1)) {
				currentNode = currentNode.nextNode;
				counter++;
			}
			linkedNode.nextNode = currentNode.nextNode;
			currentNode.nextNode = linkedNode;
		}
	}

	public void add(LinkedNode linkedNode) {
		add(linkedNode, -1);
	}

	public void delete(LinkedNode linkedNode) {
		LinkedNode currentNode = head;
		if (linkedNode == head) {
			head = head.nextNode;
		} else {
			while (currentNode.nextNode != null) {
				if (currentNode.nextNode == linkedNode) {
					currentNode.nextNode = currentNode.nextNode.nextNode;
					break;
				} else {
					currentNode = currentNode.nextNode;
				}
			}
		}
	}

	public int getLenght() {
		LinkedNode currentNode = head;
		int counter = 0;
		while (currentNode != null) {
			currentNode = currentNode.nextNode;
			counter++;
		}
		return counter;
	}

	@Override
	public String toString() {
		return "LinkedList [head=" + head + "]";
	}
}
