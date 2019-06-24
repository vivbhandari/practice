package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	public Interval(int s, int e) {
		start = s;
		end = e;
	}

	public String toString() {
		return "[" + start + "," + end + "]";
	}
}

public class Solution {
	public static List<Interval> merge(List<Interval> intervals) {
		List<Interval> output = new ArrayList<Interval>();

		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval one, Interval two) {
				return one.start - two.start;
			}
		});

		Interval prev = null;
		for (Interval interval : intervals) {
			if (prev == null) {
				prev = interval;
				output.add(interval);
			} else {
				if (prev.end >= interval.start) {
					prev.end = Math.max(prev.end, interval.end);
				} else {
					prev = interval;
					output.add(interval);
				}
			}
		}

		return output;
	}

	public static void main(String args[]) {
		// [[2,3],[2,2],[3,3],[1,3],[5,7],[2,2],[4,6]]
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(2, 3));
		intervals.add(new Interval(2, 2));
		intervals.add(new Interval(3, 3));
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(5, 7));
		intervals.add(new Interval(2, 2));
		intervals.add(new Interval(4, 6));
		System.out.println(merge(intervals));
	}
}
