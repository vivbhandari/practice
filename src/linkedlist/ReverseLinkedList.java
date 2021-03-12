package linkedlist;

public class ReverseLinkedList {
	public static LinkedNode reverse(LinkedNode head) {
		LinkedNode dummy = new LinkedNode(-1, head);
		LinkedNode next = head.nextNode;

		while (next != null) {
			head.nextNode = next.nextNode;
			next.nextNode = dummy.nextNode;
			dummy.nextNode = next;
			next = head.nextNode;
		}
		return dummy.nextNode;
	}

	public static void main(String args[]) {
		LinkedList linkedList = new LinkedList();
		for (int i = 0; i < 5; i++) {
			LinkedNode linkedNode = new LinkedNode(i);
			linkedList.add(linkedNode);
		}

		System.out.println(linkedList);
		System.out.println(reverse(linkedList.head));
	}
}
