package bst;

import java.util.Arrays;
import java.util.List;

public class BSTTest {

	public static void main(String args[]) {
		Tree tree = new Tree();
		List<Integer> input = Arrays.asList(new Integer[] { 10, 5, 15, 3, 8,
				12, 18, 2, 4, 6, 9, 7 });
		for (int i : input) {
			BSTNode node = new BSTNode(i);
			tree.addNode(node);
			System.out.println(tree);
		}
		System.out.println(tree.getNode(10));
		System.out.println(tree.getNode(2));
		System.out.println(tree.getNode(18));
		System.out.println(tree.getNode(5));
		System.out.println(tree.deleteNode(5));
		System.out.println(tree);
		System.out.println(tree.getNode(6));
		System.out.println(tree.deleteNode(7));
		System.out.println(tree);
		System.out.println(tree.deleteNode(8));
		System.out.println(tree);
	}
}
