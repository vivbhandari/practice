package bst;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

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

	private static Tree createNewTree(){
		Tree tree = new Tree();
		List<Integer> input = Arrays.asList(
				new Integer[] { 10, 5, 15, 3, 8, 12, 18, 2, 4, 6, 9, 7 });
		for (int i : input) {
			BSTNode node = new BSTNode(i);
			tree.addNode(node);
//			System.out.println(tree);
		}
		return tree;
	}
	
	private static void printList(BSTNode head){
		BSTNode current = head;
		while(current != null){
			System.out.println(current.value);
			current = current.rightChild;
			if(current == head)
				break;
		}
	}
	
	public static void main(String args[]) {
		Tree tree = createNewTree();
		printList(tree.convertToDoubleLinklist());
		
//		printTree(tree.root);
//		System.out.println(calculateStats(tree.root));
//		System.out.println(tree.getNode(10));
//		System.out.println(tree.getNode(2));
//		System.out.println(tree.getNode(18));
//		System.out.println(tree.getNode(5));
//		System.out.println(tree.deleteNode(5));
//		System.out.println(tree);
//		System.out.println(tree.getNode(6));
//		System.out.println(tree.deleteNode(7));
//		System.out.println(tree);
//		System.out.println(tree.deleteNode(8));
//		System.out.println(tree);
	}

	public static void printTree(BSTNode root) {
		List<StringBuilder> tree = new ArrayList<>();
		Queue<BSTNode> toBeProcessed = new ArrayDeque<>();
		toBeProcessed.add(root);
		while (!toBeProcessed.isEmpty()) {
			int limit = toBeProcessed.size();

			int length = 1;
			if (tree.size() > 0) {
				for(int i=0;i<tree.size();i++)
					tree.get(i).insert(0, "  ");
				length = tree.get(tree.size() - 1).length() + 1;
			}
			StringBuilder str = new StringBuilder();
			while (length-- > 0)
				str.append("  ");
			tree.add(str);
			int offset = 0;

			while (limit-- > 0) {
				BSTNode node = toBeProcessed.poll();
				if (node.leftChild != null)
					toBeProcessed.add(node.leftChild);
				if (node.rightChild != null)
					toBeProcessed.add(node.rightChild);
				if(node.value < 10)
					str.replace(offset, offset, " ");
				str.replace(offset+1, offset+1, "" + node.value);
				offset += 4;
			}
		}
		for(StringBuilder s: tree)
			System.out.println(s);
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
