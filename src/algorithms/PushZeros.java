package algorithms;

import java.util.Arrays;

public class PushZeros {
	
	public static void push(int[] input) {
		int index = 0;
		for(int i=0;i<input.length;i++){
			if(input[i] != 0){
				input[index++] = input[i];
			}
			if(index-1 != i)
				input[i] = 0;
		}
	}

	public static void main(String args[]) {
		int[] input = new int[]{1,2,3,0,0,4,0,5,6,0,0,0,7};
		push(input);
		System.out.println(Arrays.toString(input));
	}
}
