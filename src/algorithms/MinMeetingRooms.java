package algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinMeetingRooms {
	public static int minMeetingRooms(float[][] intervals) {
		// Arrays.sort(intervals, Comparator.comparing((int[] itv) -> itv[0]));
		Arrays.sort(intervals, new Comparator<float[]>() {
			public int compare(float one[], float two[]) {
				return (int) Math.ceil((one[0] - two[0]));
			}
		});
		PriorityQueue<Float> minHeap = new PriorityQueue<>();
		int count = 0;
		for (float[] interval : intervals) {
			if (minHeap.isEmpty()) {
				count++;
			} else {
				if (interval[0] >= minHeap.peek())
					minHeap.poll();
				else
					count++;
			}
			minHeap.offer(interval[1]);
		}
		return count;
	}

	public static void main(String args[]) {
		System.out.println(minMeetingRooms(new float[][] { { 1, 2 },
				{ 1.5f, 2.5f }, { 2, 3 }, { 2.5f, 3 }, { 3, 4 }, { 3, 4 } }));
	}
}
