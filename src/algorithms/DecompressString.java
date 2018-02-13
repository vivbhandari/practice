package algorithms;

import java.util.Stack;

public class DecompressString {

	public String decompress(String input) {
		boolean startNew = false;
		Stack<String> stack = new Stack<String>();

		for (int i = 0; i < input.length(); i++) {
			Character ch = input.charAt(i);
			if (ch == '(') {
				startNew = true;
			} else if (ch == ')') {
				int nextIndex = input.indexOf('}', i);
				int count = Integer.parseInt(input.substring(i + 2, nextIndex));
				String prevStr = stack.pop();
				String repStr = "";
				while (count-- > 0)
					repStr += prevStr;
				if (stack.isEmpty())
					stack.push(repStr);
				else
					stack.push(stack.pop() + repStr);
				i = nextIndex;
			} else {
				if (startNew || stack.isEmpty()) {
					stack.push(ch.toString());
					startNew = false;
				} else
					stack.push(stack.pop() + ch);
			}
		}
		String output = stack.toString();
		return output.substring(1, output.length() - 1);
	}

	public static void main(String args[]) {
		DecompressString decompressString = new DecompressString();
		System.out.println(decompressString.decompress("a(b(c){2}){2}d"));
		System.out.println(decompressString.decompress("((x){3}(y){2}z){2}"));
		System.out.println(decompressString.decompress("a(b(x){3}(y){2}z){2}c"));
		System.out.println(decompressString.decompress("abc"));
	}
}
