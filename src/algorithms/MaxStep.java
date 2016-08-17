package algorithms;

public class MaxStep {

	public static int maxStep(int currentStep, int numOfMoves, int brokenStep) {
		int stepSoFar = 0;
		for (int i = 1; i <= numOfMoves; i++) {
			if (currentStep + stepSoFar + i == brokenStep) {
				continue;
			} else {
				stepSoFar += i;
			}
		}
		return currentStep + stepSoFar;
	}

	public static void main(String args[]) {
		int answer = maxStep(0, 3, 3);
		System.out.println("Final step=" + answer);
	}
}
