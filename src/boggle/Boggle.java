package boggle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Boggle {

	HashSet<String> dictionary;
	char[][] board;
	static int iterations;

	public Boggle(char[][] board, HashSet<String> dictionary) {
		this.board = board;
		this.dictionary = dictionary;
	}

	private void findWordsRecurse(StringBuilder currentWord, int curRow,
			int curCol, boolean[][] visited, Set<String> result) {
		iterations++;
		visited[curRow][curCol] = true;
		currentWord.append(board[curRow][curCol]);

		String currentWordStr = currentWord.toString();
		if (dictionary.contains(currentWordStr)) {
			result.add(currentWordStr);
		}

		int rowStart = Math.max(curRow - 1, 0);
		int rowEnd = Math.min(curRow + 1, board.length - 1);
		int colStart = Math.max(curCol - 1, 0);
		int colEnd = Math.min(curCol + 1, board[0].length - 1);
		for (int row = rowStart; row <= rowEnd; row++) {
			for (int column = colStart; column <= colEnd; column++) {
				if (visited[row][column] == false) {
					findWordsRecurse(currentWord, row, column, visited, result);
				}
			}
		}
		currentWord.deleteCharAt(currentWord.length() - 1);
		visited[curRow][curCol] = false;
	}

	public Set<String> findWords() {
		Set<String> result = new HashSet<String>();

		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board[0].length; column++) {
				StringBuilder currentWord = new StringBuilder("");
				findWordsRecurse(currentWord, row, column,
						new boolean[board.length][board[0].length], result);
			}
		}

		return result;
	}

	public static void main(String args[]) {
//		char[][] board = new char[][] { { 'G', 'I', 'Z', 'N' },
//				{ 'U', 'E', 'S', 'O' }, { 'Q', 'E', 'K', 'L' },
//				{ 'N', 'H', 'E', 'L' }, { 'O', 'T', 'I', 'M' } };

		// char[][] board = new char[][] { { 'G', 'I', 'Z', 'N' },
		// { 'U', 'E', 'S', 'O' }, { 'Q', 'E', 'K', 'L' },
		// { 'N', 'H', 'E', 'L' } };

		char[][] board = new char[][] { 
				{ 'G', 'I', 'Z' }, 
				{ 'U', 'E', 'S' },
				{ 'Q', 'E', 'K' } };
		HashSet<String> dictionary = new HashSet<String>(
				Arrays.asList(new String[] { "GEEK", "QUIZ", "HELLO", "SEEK",
						"SON", "SEEN", "THEN", "NOT", "HOT", "HELL", "NOTE",
						"HOTEL", "HIT", "ILL", "HILL", "IT", "MET", "HIM",
						"HEM", "MEEK", "MELON", "THEM", "TELL", "LEEK", "HEEL",
						"HEN", "NOTE" }));

		Boggle boggle = new Boggle(board, dictionary);
		long start = System.currentTimeMillis();
		Set<String> result = boggle.findWords();
		System.out.println(result);
		System.out.println("found all=" + dictionary.containsAll(result));

		System.out
				.println("Time taken=" + (System.currentTimeMillis() - start));
		System.out.print("iterations="+iterations);
	}
}
