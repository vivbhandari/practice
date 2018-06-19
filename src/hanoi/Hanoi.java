package hanoi;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Hanoi {

	List<Stack<Integer>> towers = new ArrayList<Stack<Integer>>();
	int numberOfPlates;

	public Hanoi(int numberOfPlates) {
		this.numberOfPlates = numberOfPlates;
		for (int i = 0; i < 3; i++) {
			towers.add(new Stack<Integer>());
		}
		for (int i = numberOfPlates; i > 0; i--) {
			towers.get(0).add(i);
		}
	}

	private void moveTop(int from, int to) {
		if (!towers.get(to).isEmpty()
				&& towers.get(to).peek() < towers.get(from).peek())
			throw new IllegalArgumentException("Invalid move!!");
		System.out.println("Move " + towers.get(from).peek() + " from " + from
				+ " to " + to);
		towers.get(to).add(towers.get(from).pop());
	}

	private void play(int n, int source, int buffer, int destination) {
		if (n > 0) {
			play(n - 1, source, destination, buffer);
			moveTop(source, destination);
			play(n - 1, buffer, source, destination);
		}
	}

	public void play() {
		printState();
		play(numberOfPlates, 0, 1, 2);
		printState();
	}

	private void printState() {
		for (int i = 0; i < 3; i++) {
			System.out.println("Tower " + i + "->" + towers.get(i).toString());
		}
	}

	public static void main(String args[]) {
		Hanoi hanoi = new Hanoi(5);
		hanoi.play();
	}
}
