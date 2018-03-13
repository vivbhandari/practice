package linkedlist;

public class TestLinkedList {

	static int counter = 0;

	private static LinkedNode reverse(LinkedNode cur, LinkedNode prev) {
		LinkedNode newHead = null;
		if (cur.nextNode == null) {
			newHead = cur;
		} else {
			newHead = reverse(cur.nextNode, cur);
		}
		cur.nextNode = prev;
		return newHead;
	}

	private static LinkedNode reverseItr(LinkedNode head) {
		LinkedNode dummy = new LinkedNode(-1) ;
		dummy.nextNode = head;
		LinkedNode move = head.nextNode;
		
		while(move != null ){
			head.nextNode = move.nextNode;
			move.nextNode = dummy.nextNode;
			dummy.nextNode = move;
			move = head.nextNode;
		}
		
		return dummy.nextNode;
	}

	private static LinkedNode recurse(LinkedNode currentNode, int n) {
		LinkedNode targetNode = null;
		if (currentNode != null) {
			targetNode = recurse(currentNode.nextNode, n);
			if (n == counter) {
				targetNode = currentNode;
			}
		}
		counter++;

		return targetNode;
	}

	public static LinkedNode getFromEnd(LinkedList linkedList, int n) {
		counter = 0;
		return recurse(linkedList.head, n);
	}

	public static LinkedNode getFromEndIterative(LinkedList linkedList, int n) {
		LinkedNode nthNode = null;
		LinkedNode currentNode = linkedList.head;
		int counter = 1;
		while (currentNode != null) {
			if (counter == n) {
				nthNode = linkedList.head;
			} else if (counter > n) {
				nthNode = nthNode.nextNode;
			}
			currentNode = currentNode.nextNode;
			counter++;
		}
		return nthNode;
	}

	public static void main(String args[]) {
		LinkedList linkedList = new LinkedList();
		for (int i = 0; i < 5; i++) {
			LinkedNode linkedNode = new LinkedNode(i);
			linkedList.add(linkedNode);
		}

		System.out.println(linkedList);
//		System.out.println(reverse(linkedList.head, null));
		System.out.println(reverseItr(linkedList.head));
//		System.out.println(linkedList.getLenght());
//		System.out.println(linkedList.get(3));
//		linkedList.delete(linkedList.get(3));
//		System.out.println(linkedList);
//		linkedList.delete(linkedList.get(0));
//		System.out.println(linkedList);
//		linkedList.add(new LinkedNode(3), 2);
//		System.out.println(linkedList);
//		linkedList.add(new LinkedNode(5), 7);
//		System.out.println(linkedList);
//		linkedList.add(new LinkedNode(0), 0);
//		System.out.println(linkedList);
//		System.out.println(getFromEnd(linkedList, 1));
//		System.out.println(getFromEnd(linkedList, 3));
//		System.out.println(getFromEnd(linkedList, 6));
//		System.out.println(getFromEnd(linkedList, 8));
//
//		System.out.println(getFromEndIterative(linkedList, 1));
//		System.out.println(getFromEndIterative(linkedList, 3));
//		System.out.println(getFromEndIterative(linkedList, 6));
//		System.out.println(getFromEndIterative(linkedList, 8));
	}
}
