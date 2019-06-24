package algorithms;

public class CodeSignal {
	public static boolean alternatingSort(int[] a) {
		int n = a.length;
		int[] b = new int[n];
		int bIndex = -1;
		for (int i = 0; i < n / 2; i++) {
			b[++bIndex] = a[i];
			b[++bIndex] = a[n - i - 1];
		}
		if (n % 2 == 1)
			b[++bIndex] = a[n / 2];
		for (int j = 0; j < n; j++) {
			if (j != n - 1 && b[j] > b[j + 1])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] a = { 1 };
		System.out.println(alternatingSort(a));
	}
}
