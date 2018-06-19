package linkedlist;

public class ReverseLinkedList {
	public static LinkedNode reverse(LinkedNode head) {
		LinkedNode newHead = null;
		LinkedNode cur = head;

		while (cur != null) {
			LinkedNode tmp = newHead;
			LinkedNode tmp2 = cur.nextNode;
			newHead = cur;
			cur.nextNode = tmp; 
			cur = tmp2;
		}
		return newHead;
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
