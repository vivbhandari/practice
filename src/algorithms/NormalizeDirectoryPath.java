package algorithms;

import java.util.Stack;
import java.util.StringTokenizer;

public class NormalizeDirectoryPath {

	public static String getNormalizedPath(String input) {
		Stack<String> stack = new Stack<String>();
		String doubleDot = "..";
		String singleDot = ".";
		String forwardSlash = "/";
		String normalizedPath = "";

		StringTokenizer tokens = new StringTokenizer(input, forwardSlash);
		while (tokens.hasMoreTokens()) {
			String token = tokens.nextToken();

			if (token.equals(doubleDot)) {
				if (stack.isEmpty()) {
					throw new IllegalArgumentException("Invalid path");
				}
				stack.pop();
			} else if (token.equals(singleDot)) {
				continue;
			} else {
				stack.push(token);
			}
		}

		for (String dir : stack) {
			normalizedPath += forwardSlash + dir;
		}

		if (normalizedPath.isEmpty()) {
			normalizedPath = forwardSlash;
		}

		return normalizedPath;
	}

	public static void main(String args[]) {
		String[] inputs = { "", "/", "/foo", "/foo/..", "/foo/bar",
				"/foo/bar/..", "/foo///bar/", "/foo/./bar", "/foo/../../" };
		for (String input : inputs) {
			System.out.println(getNormalizedPath(input));
		}
	}
}
