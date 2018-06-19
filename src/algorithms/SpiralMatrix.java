package algorithms;

public class SpiralMatrix {
	public static String spiralOrder(char[][] matrix) {
		if (matrix.length == 0)
			return null;
		int rows = matrix.length, cols = matrix[0].length;
		char[] elements = new char[rows * cols];
		int curRow = 0, curCol = -1;
		int index = 0;
		while (true) {
			for (int i = 0; i < cols; i++) {
				elements[index++] = matrix[curRow][++curCol];
			}
			if (--rows == 0)
				break;
			for (int i = 0; i < rows; i++) {
				elements[index++] = matrix[++curRow][curCol];
			}
			if (--cols == 0)
				break;
			for (int i = 0; i < cols; i++) {
				elements[index++] = matrix[curRow][--curCol];
			}
			if (--rows == 0)
				break;
			for (int i = 0; i < rows; i++) {
				elements[index++] = matrix[--curRow][curCol];
			}
			if (--cols == 0)
				break;
		}
		return new String(elements);
	}

	public static void main(String args[]) {
		char[][] matrix = { 
				{ 'h', 'a', 'v', 'e' }, 
				{ 'd', 'a', 'y', 'a' },
				{ 'e', 'c', 'i', 'n' } };
		System.out.println(spiralOrder(matrix));
		
		char[][] matrix2 = { 
				{ 'h', 'a', 'v' }, 
				{ 'd', 'a', 'e' },
				{ 'e', 'y', 'a' }, 
				{ 'c', 'i', 'n' } };
		System.out.println(spiralOrder(matrix2));

		char[][] matrix3 = { 
				{ 'h', 'a', 'v' ,'e', 'a', 'n', 'i', 'c', 'e', 'd', 'a', 'y' }};
		System.out.println(spiralOrder(matrix3));

		char[][] matrix4 = { 
				{ 'h'}, {'a'}, {'v'} ,{'e'}, {'a'}, {'n'}, {'i'}, {'c'}, {'e'}, {'d'}, {'a'}, {'y'} };
		System.out.println(spiralOrder(matrix4));
	}
}
